package net.sre.batchprocessing.repository;

import net.sre.batchprocessing.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
