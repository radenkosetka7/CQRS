package org.example.cqrswrite.controller;

import lombok.RequiredArgsConstructor;
import org.example.cqrswrite.dto.StudentRequest;
import org.example.cqrswrite.service.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody StudentRequest studentRequest) {
        studentService.write(studentRequest);
        return ResponseEntity.ok("Student created successfully");
    }

}
