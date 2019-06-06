package com.psoft.lab03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.psoft.lab03.Exception.TokenIncorrect;
import com.psoft.lab03.authentication.TokenFilter;

@SpringBootApplication
public class Lab02Application {

	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		try {
			FilterRegistrationBean<TokenFilter> filterRb = new FilterRegistrationBean<>();
			filterRb.setFilter(new TokenFilter());
			System.out.println("OKOK");
			filterRb.addUrlPatterns("/v1/products/*");
			
			return filterRb;
		} catch (Exception e) {
			throw new TokenIncorrect("Token incorreto ou expirado!");
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Lab02Application.class, args);
	}
}
