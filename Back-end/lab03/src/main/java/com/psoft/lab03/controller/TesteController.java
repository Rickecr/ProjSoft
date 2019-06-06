package com.psoft.lab03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	
	@GetMapping("/private")
	public String get() {
		return "OII";
	}
	
}
