package com.madhav.javawithh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LenadenabankApplication {

    public static void main(String[] args) {
        SpringApplication.run(LenadenabankApplication.class, args);
        System.out.println("Bank Service Started");
    }
}