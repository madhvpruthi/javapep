package com.madhav.javawithh2;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println("User Password:");
        System.out.println(encoder.encode("password"));

        System.out.println();

        System.out.println("Admin Password:");
        System.out.println(encoder.encode("adminpass"));
    }
}