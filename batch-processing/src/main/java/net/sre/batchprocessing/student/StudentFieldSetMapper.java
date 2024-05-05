package net.sre.batchprocessing.student;

import lombok.NonNull;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class StudentFieldSetMapper implements FieldSetMapper<Student> {
    @Override
    public Student mapFieldSet(@NonNull FieldSet fieldSet) throws BindException {
        if(fieldSet == null) {
            return null;
        }
        Student student = new Student();

        student.setFirstName(fieldSet.readString(1));
        student.setLastName(fieldSet.readString(2));
        student.setAge(fieldSet.readInt(3));

        return student;
    }

}
