package com.example.rabbitdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitDemoApplication implements CommandLineRunner {

	private final MessageProducer producer;

	public RabbitDemoApplication(MessageProducer producer) {
		this.producer = producer;
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		producer.sendMessage("Hello RabbitMQ with multiple queues!");
	}
}
