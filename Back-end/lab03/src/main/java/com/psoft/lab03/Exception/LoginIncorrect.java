package com.psoft.lab03.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class LoginIncorrect extends RuntimeException {

	public LoginIncorrect(String msg) {
		super(msg);
	}
	
}
