package com.example.demo;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacaoController {

	@RequestMapping("/saudacao")
	public Saudacao saudacao(@RequestParam(value="name", defaultValue="World", required=false) String name) {
		return new Saudacao(name, saudacao());
	}
	
	private String saudacao() {
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
        
        return saudacao;
	}
	
	@RequestMapping("/timeJson")
	public Time time() {
		LocalTime localTime = LocalTime.now();
		return new Time(localTime.toString());
	}
}
