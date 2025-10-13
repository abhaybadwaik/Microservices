package com.example.RabbitMQ.Producer;

import com.example.RabbitMQ.RabbitMQConfig.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(
                "EXCHANGE1",
                "ROUTING_KEY2",
                message
        );
        System.out.println("📤 Sent message: " + message);
    }
}
