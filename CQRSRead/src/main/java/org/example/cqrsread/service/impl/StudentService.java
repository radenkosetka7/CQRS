package org.example.cqrsread.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cqrsread.dto.StudentResponse;
import org.example.cqrsread.repository.StudentRepository;
import org.example.cqrsread.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;

    @Override
    public Optional<StudentResponse> getStudent(Long id) {

        log.info("Getting student with id: {}", id);

        return studentRepository.findById(id)
                .map(student -> new StudentResponse(student.getId(), student.getName(), student.getEmail(), student.getAvgGrade()
                ));
    }
}
