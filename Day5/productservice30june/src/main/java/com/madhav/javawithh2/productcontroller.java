package com.madhav.javawithh2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productcontroller {

    @GetMapping("/products")
    public String getProducts() throws Exception {

        Thread.sleep(5000);

        return "Laptop Price = ₹80000";
    }
}