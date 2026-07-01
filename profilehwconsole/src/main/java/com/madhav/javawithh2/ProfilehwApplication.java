package com.madhav.javawithh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.madhav.javawithh2.console.EmployeeConsole;

@SpringBootApplication
public class ProfilehwApplication implements CommandLineRunner {

    @Autowired
    private EmployeeConsole console;

    public static void main(String[] args) {
        SpringApplication.run(ProfilehwApplication.class, args);
    }

    @Override
    public void run(String... args) {

        new Thread(() -> {

            console.start();

        }).start();

    }

}