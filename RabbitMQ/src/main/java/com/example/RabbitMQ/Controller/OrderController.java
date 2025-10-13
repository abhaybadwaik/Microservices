package com.example.RabbitMQ.Controller;

import com.example.RabbitMQ.Producer.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderProducer producer;

    public OrderController(OrderProducer producer){
        this.producer=producer;
    }

    @PostMapping("/send")
    public String send(@RequestParam String message){
        producer.send(message);
        return "Message sent: " + message;
    }
}
