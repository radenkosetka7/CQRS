package org.example.cqrswrite.publisher;

import lombok.RequiredArgsConstructor;
import org.example.cqrswrite.config.RabbitMQConfig;
import org.example.cqrswrite.model.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishStudentCreatedEvent(Student student) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, student);
    }
}
