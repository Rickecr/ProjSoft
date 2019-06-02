package com.lab3aux.lab3aux.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello";
	}
	
}
