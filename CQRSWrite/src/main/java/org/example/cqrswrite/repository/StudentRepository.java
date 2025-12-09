package org.example.cqrswrite.repository;

import org.example.cqrswrite.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
