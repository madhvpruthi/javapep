package com.madhav.firstspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {
	@GetMapping("/hello")
	public String sayhello() {
		return "Hello Spring Boot App";
		
	}
}
