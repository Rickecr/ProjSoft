package com.psoft.lab03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.psoft.lab03.authentication.TokenFilter;

@SpringBootApplication
public class Lab02Application {

	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> filterRb = new FilterRegistrationBean<>();
		filterRb.setFilter(new TokenFilter());
		System.out.println("OKOK");
		filterRb.addUrlPatterns("/v1/products/*");
		
		return filterRb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Lab02Application.class, args);
	}
}
