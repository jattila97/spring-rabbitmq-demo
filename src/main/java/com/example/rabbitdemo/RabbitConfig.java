package com.example.rabbitdemo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE_NAME = "demo-exchange";
    public static final String ROUTING_KEY = "demo.key";

    public static final String DEMO_QUEUE = "demo-queue";
    public static final String DEMO_QUEUE2 = "demo-queue2";

    @Bean
    public Queue demoQueue() {
        return new Queue(DEMO_QUEUE, false);
    }

    @Bean
    public Queue auditQueue() {
        return new Queue(DEMO_QUEUE2, false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingDemo(Queue demoQueue, DirectExchange exchange) {
        return BindingBuilder.bind(demoQueue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding bindingAudit(Queue auditQueue, DirectExchange exchange) {
        return BindingBuilder.bind(auditQueue).to(exchange).with(ROUTING_KEY);
    }
}
