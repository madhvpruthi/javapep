package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCartServiceController {
	@GetMapping("/cart")
	public String cart()
	{
		return "Cart service 2 items in the cart";
	}
}
