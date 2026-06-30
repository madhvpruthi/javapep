package com.madhav.javawithh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class productsyncservice {

    @Autowired
    private RestTemplate restTemplate;

    public String fetchProductSync() {

        String response =
                restTemplate.getForObject(
                        "http://localhost:8181/products",
                        String.class);

        System.out.println("Sync Response : " + response);

        return response;
    }
}