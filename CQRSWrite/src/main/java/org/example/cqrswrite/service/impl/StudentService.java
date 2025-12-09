package org.example.cqrswrite.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cqrswrite.dto.StudentRequest;
import org.example.cqrswrite.model.Student;
import org.example.cqrswrite.publisher.StudentEventPublisher;
import org.example.cqrswrite.repository.StudentRepository;
import org.example.cqrswrite.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final StudentEventPublisher studentEventPublisher;


    @Override
    public void write(StudentRequest request) {

        log.info("Inserting student with name: {}", request.name());

        Student student = Student.builder()
                .name(request.name())
                .email(request.email())
                .avgGrade(request.avgGrade())
                .build();

        studentRepository.save(student);

        studentEventPublisher.publishStudentCreatedEvent(student);

    }
}
