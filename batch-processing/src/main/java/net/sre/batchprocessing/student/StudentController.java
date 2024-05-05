package net.sre.batchprocessing.student;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private static final String TEMP_STORAGE = "D:/jasper/";
    private final JobLauncher jobLauncher;
    private final Job job;

    @GetMapping
    public void importCsvToDBJob(@RequestParam("file")MultipartFile multipartFile)
    {


        try
        {
            String originalFileName = multipartFile.getOriginalFilename();
            File fileToImport = new File(TEMP_STORAGE+originalFileName);
            multipartFile.transferTo(fileToImport);

            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("fullPathFileName", TEMP_STORAGE + originalFileName)
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();

            JobExecution execution = jobLauncher.run(job, jobParameters);

//            if(execution.getExitStatus().getExitCode().equals(ExitStatus.COMPLETED)){
//                Files.deleteIfExists(Paths.get(TEMP_STORAGE + originalFileName));
//            }
        }
        catch (JobExecutionAlreadyRunningException
               | JobInstanceAlreadyCompleteException
               | JobRestartException
               | JobParametersInvalidException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
