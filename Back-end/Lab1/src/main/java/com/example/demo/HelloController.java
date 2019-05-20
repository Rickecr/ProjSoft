package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HelloController {

	@GetMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        String saudacao = "";
        LocalTime localTime = LocalTime.now();
        int horas = localTime.getHour();
        if (horas <= 12) {
        	saudacao = "bom dia";
        } else if (horas > 12 && horas < 18) {
        	saudacao = "boa tarde";
        } else if (horas >= 18) {
        	saudacao = "boa noite";
        }
        model.addAttribute("saudacao", saudacao);
        
        return "hello";
    }
	
	@GetMapping("/time")
	public String time(Model model) {
		LocalTime localTime = LocalTime.now();
		model.addAttribute("time", localTime.toString());
		return "time";
	}
}
