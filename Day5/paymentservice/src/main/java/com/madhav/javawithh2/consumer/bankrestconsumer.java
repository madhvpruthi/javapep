package com.madhav.javawithh2.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class bankrestconsumer {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getBankData() {

        List<ServiceInstance> instances =
                discoveryClient.getInstances("BANK-SERVICE");

        if(instances==null || instances.isEmpty()) {
            return "BANK SERVICE NOT AVAILABLE";
        }

        ServiceInstance service = instances.get(0);

        String url = service.getUri() + "/bank/payment";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, String.class);

    }

}