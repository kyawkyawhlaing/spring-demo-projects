package net.sre.batchprocessing.config;

import lombok.NonNull;
import net.sre.batchprocessing.student.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student, Student> {
    @Override
    public Student process(@NonNull Student student) throws Exception {
        return student;
    }
}
