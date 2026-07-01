package com.madhav.javawithh2.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class cartrestconsumer {
	@Autowired
	private DiscoveryClient discoveryClient;
	public String getcardata(){
		
		List<ServiceInstance> instance = discoveryClient.getInstances("CART-SERVICE");
		if(instance == null || instance.isEmpty()) {
			return "CART SERVICE NOT AVAILABLE FOR NOW";
		}
		ServiceInstance instance2 =instance.get(0);
		
		String url =  instance2.getUri()+"/cart/getdata";
		
		RestTemplate resttemplate = new RestTemplate();
		return resttemplate.getForObject(url, String.class);
		
		
	}
}
