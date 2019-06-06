package com.psoft.lab03.Exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {

	public UserNotFound(String msg) {
		super(msg);
	}
	
}
