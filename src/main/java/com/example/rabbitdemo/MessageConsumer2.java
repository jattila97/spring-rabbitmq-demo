package com.example.rabbitdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer2 {

    @RabbitListener(queues = RabbitConfig.DEMO_QUEUE2)
    public void handleAuditMessage(String message) {
        System.out.println("AuditQueue logged: " + message);
    }
}
