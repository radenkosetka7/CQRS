package org.example.cqrsread.repository;

import org.example.cqrsread.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
