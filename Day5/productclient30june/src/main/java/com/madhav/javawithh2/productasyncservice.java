package com.madhav.javawithh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class productasyncservice {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public void fetchProductAsync() {

        String response =
                restTemplate.getForObject(
                        "http://localhost:8181/products",
                        String.class);

        System.out.println("Async Response : " + response);
    }

}