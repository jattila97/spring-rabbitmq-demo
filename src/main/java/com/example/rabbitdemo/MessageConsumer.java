package com.example.rabbitdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitConfig.DEMO_QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received: " + message);
    }
}
