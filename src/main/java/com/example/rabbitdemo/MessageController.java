package com.example.rabbitdemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageProducer producer;

    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        producer.sendMessage(message);
        return "Message sent: " + message;
    }
}
