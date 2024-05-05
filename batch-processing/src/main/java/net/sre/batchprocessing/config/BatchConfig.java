package net.sre.batchprocessing.config;

import lombok.RequiredArgsConstructor;

import net.sre.batchprocessing.repository.StudentRepository;
import net.sre.batchprocessing.student.Student;
import net.sre.batchprocessing.student.StudentFieldSetMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.File;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final StudentRepository repository;

    @Bean
    @StepScope
    public FlatFileItemReader<Student> reader(@Value("#{jobParameters[fullPathFileName]}") String pathToFile)
    {
        FlatFileItemReader<Student> itemReader = new FlatFileItemReader<Student>();
//        itemReader.setResource(new FileSystemResource("src/main/resources/students.csv"));
        itemReader.setResource(new FileSystemResource((new File(pathToFile))));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }
    @Bean
    public StudentProcessor processor()
    {
        return new StudentProcessor();
    }
    @Bean
    public RepositoryItemWriter<Student> writer()
    {
        RepositoryItemWriter<Student> writer = new RepositoryItemWriter<>();
        writer.setRepository(repository);
        writer.setMethodName("save");
        return writer;
    }
    @Bean
    public Step step1(FlatFileItemReader<Student> itemReader)
    {
        return new StepBuilder("csvImport", jobRepository)
                .<Student, Student>chunk(1000, platformTransactionManager)
                .reader(itemReader)
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }
    @Bean
    public Job runJob(FlatFileItemReader<Student> itemReader)
    {
        return new JobBuilder("importStudents", jobRepository)
                .start(step1(itemReader))
                .build();
    }
    @Bean
    public TaskExecutor taskExecutor()
    {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
    private LineMapper<Student> lineMapper()
    {
        DefaultLineMapper<Student> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(new StudentFieldSetMapper());

        return lineMapper;
    }

}
