package org.example.cqrswrite.service;

import org.example.cqrswrite.dto.StudentRequest;

public interface IStudentService {

    void write(StudentRequest request);
}
