package org.example.cqrsread.listener;

import lombok.RequiredArgsConstructor;
import org.example.cqrsread.config.RabbitMQConfig;
import org.example.cqrsread.model.Student;
import org.example.cqrsread.repository.StudentRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class StudentEventListener {

    private final StudentRepository studentRepository;

    @Transactional
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleUserCreatedEvent(Student student) {
        studentRepository.save(student);
    }

}
