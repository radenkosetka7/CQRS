package org.example.cqrsread.service;

import org.example.cqrsread.dto.StudentResponse;

import java.util.Optional;

public interface IStudentService {

    Optional<StudentResponse> getStudent(Long id);
}
