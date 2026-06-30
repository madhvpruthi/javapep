package com.madhav.javawithh2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhav.javawithh2.consumer.bankrestconsumer;
import com.madhav.javawithh2.consumer.cartrestconsumer;

@RestController
public class paymentrestcontroller {

    @Autowired
    private cartrestconsumer cart;

    @Autowired
    private bankrestconsumer bank;

    @GetMapping("/payment/getdata")
    public String getpaymentdata() {

        return "FROM PAYMENT SERVICE\n\n"
                + cart.getcardata()
                + "\n\n"
                + bank.getBankData();

    }

}