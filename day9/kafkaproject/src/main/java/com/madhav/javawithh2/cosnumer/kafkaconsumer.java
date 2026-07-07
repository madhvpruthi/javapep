package com.madhav.javawithh2.cosnumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class kafkaconsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void consume(String message) {

        System.out.println("Producer Sent Consumer Received : " + message);

        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}