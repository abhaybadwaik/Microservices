package com.example.RabbitMQ.RabbitMQConfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Bean
    public Queue queue() {
        return new Queue("QUEUE1", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("EXCHANGE1");
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("ROUTING_KEY2");
    }

    @Bean
    public Binding binding2(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("ROUTING_KEY2");
    }

}
