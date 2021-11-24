package com.example.demojms.sender;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Scheduled(fixedRate = 3000)
    public void sendMessage() {

        System.out.println("I'm sending a message");
    }
}
