package org.example.cqrsread;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class CqrsReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsReadApplication.class, args);
    }

}
