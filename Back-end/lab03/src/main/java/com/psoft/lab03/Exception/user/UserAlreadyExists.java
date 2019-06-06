package com.psoft.lab03.Exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExists extends RuntimeException {

	public UserAlreadyExists(String msg) {
		super(msg);
	}
	
}
