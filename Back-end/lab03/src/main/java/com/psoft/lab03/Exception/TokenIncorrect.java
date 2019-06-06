package com.psoft.lab03.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
public class TokenIncorrect extends RuntimeException {

	public TokenIncorrect(String msg) {
		super(msg);
	}
	
}
