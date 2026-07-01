package com.madhav.javawithh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productcontroller {

    @Autowired
    private productasyncservice asyncService;

    @Autowired
    private productsyncservice syncService;

    @GetMapping("/sync")
    public String sync() {

        String response =
                syncService.fetchProductSync();

        return "Sync Response : " + response;

    }

    @GetMapping("/async")
    public String async() {

        asyncService.fetchProductAsync();

        return "Request Accepted. Product is being fetched asynchronously.";

    }

}