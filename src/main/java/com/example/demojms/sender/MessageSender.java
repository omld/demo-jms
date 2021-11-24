package com.example.demojms.sender;

import com.example.demojms.config.RabbitConfig;
import com.example.demojms.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${demo.rabbitmq.exchange}")
    private String exchange;

    @Value("${demo.rabbitmq.routingkey}")
    private String routingkey;

    @Scheduled(fixedRate = 7000)
    public void sendMessage() {

        System.out.println("SENDER - I'm sending a message");

        Message message = Message
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World is my message")
                .build();

        rabbitTemplate.convertAndSend(exchange, routingkey, message);

        System.out.println("SENDER - Message sent");
    }

}
