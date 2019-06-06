package com.psoft.lab03.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.psoft.lab03.Exception.Product.ProductNotFoundException;
import com.psoft.lab03.Exception.user.UserAlreadyExists;
import com.psoft.lab03.Exception.user.UserNotFound;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomRestError> handleAnyException(Exception ex, WebRequest request) {
	    CustomRestError errorMessage = new CustomRestError(new Date(), ex.getMessage(), request.getDescription(false));

	    return new ResponseEntity<CustomRestError>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler({ProductNotFoundException.class, })
    public ResponseEntity<CustomRestError> notFound(Exception ex, WebRequest request) {
    	CustomRestError errorMessage = new CustomRestError(new Date(), ex.getMessage(), request.getDescription(false));

    	return new ResponseEntity<CustomRestError>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({UserNotFound.class})
    public ResponseEntity<CustomRestError> userNotFound(Exception ex, WebRequest request) {
    	CustomRestError errorMessage = new CustomRestError(new Date(), ex.getMessage(), request.getDescription(false));

    	return new ResponseEntity<CustomRestError>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({LoginIncorrect.class})
    public ResponseEntity<CustomRestError> loginIncorrect(Exception ex, WebRequest request) {
    	CustomRestError errorMessage = new CustomRestError(new Date(), ex.getMessage(), request.getDescription(false));

    	return new ResponseEntity<CustomRestError>(errorMessage, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler({UserAlreadyExists.class})
    public ResponseEntity<CustomRestError> userAlreadyExists(Exception ex, WebRequest request) {
    	CustomRestError errorMessage = new CustomRestError(new Date(), ex.getMessage(), request.getDescription(false));

    	return new ResponseEntity<CustomRestError>(errorMessage, new HttpHeaders(), HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler({TokenIncorrect.class})
    public ResponseEntity<CustomRestError> tokenIncorrect(Exception ex, WebRequest request) {
    	CustomRestError errorMessage = new CustomRestError(new Date(), ex.getMessage(), request.getDescription(false));

    	return new ResponseEntity<CustomRestError>(errorMessage, new HttpHeaders(), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }
    
}