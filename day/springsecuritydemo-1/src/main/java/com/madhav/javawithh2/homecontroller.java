package com.madhav.javawithh2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homecontroller {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to PUBLIC page";
	}
	
	@GetMapping("/user")
	public String userpage() {
		return "Welcome to USER page";
	}
	
	@GetMapping("/admin")
	public String adminpage() {
		return "Welcome to ADMIN page";
	}
	
}
