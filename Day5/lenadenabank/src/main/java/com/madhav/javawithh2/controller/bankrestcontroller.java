package com.madhav.javawithh2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bankrestcontroller {

    @GetMapping("/bank/payment")
    public String payment() {

        return "Payment Successful From BANK";

    }

}