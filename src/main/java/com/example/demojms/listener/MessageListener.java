package com.example.demojms.listener;

import com.example.demojms.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${demo.rabbitmq.queue}")
public class MessageListener {

    @RabbitHandler
    public void listen(Message message) {
        System.out.println("RECEIVER - Message Received in RabbitMQ queue");

        System.out.println("RECEIVER - Received from RabbitMQ <" + message + ">");
    }
}
