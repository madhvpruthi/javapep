package com.madhav.javawithh2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cartrestcontroller {
	
	@GetMapping("/cart/getdata")
	public String getcardata() {
		return "Returning Data from CART-SERVICE helloo";
	}
}
