package com.madhav.javawithh2.controller;

import com.madhav.javawithh2.cosnumer.kafkaconsumer;
import com.madhav.javawithh2.producer.Producer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class kafkacontroller {

    private final Producer producer;
    private final kafkaconsumer consumer;

    public kafkacontroller(Producer producer,
                           kafkaconsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @RequestMapping(value = "/publish", method = {RequestMethod.GET, RequestMethod.POST})
    public String publish(@RequestParam String message) {

        producer.sendMessage(message);

        return "Message Sent Successfully";
    }

    @GetMapping("/messages")
    public List<String> getMessages() {
        return consumer.getMessages();
    }

}