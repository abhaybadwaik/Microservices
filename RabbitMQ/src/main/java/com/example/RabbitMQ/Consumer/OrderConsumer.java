package com.example.RabbitMQ.Consumer;

import com.example.RabbitMQ.RabbitMQConfig.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @RabbitListener(queues = "QUEUE1")
    public void receive(String message){
        System.out.println("📥 Received message: " + message);
    }
}
