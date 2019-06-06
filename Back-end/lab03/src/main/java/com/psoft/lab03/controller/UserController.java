package com.psoft.lab03.controller;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.psoft.lab03.Exception.user.UserNotFound;
import com.psoft.lab03.model.LoginResponse;
import com.psoft.lab03.model.User;
import com.psoft.lab03.service.UserService;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping({"/v1/users"})
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/{login}")
	public ResponseEntity<User> getUser(@PathVariable String login) {
		User user = this.userService.findByLogin(login);
		
		if (user == null) {
			throw new UserNotFound("Usuário não existe!");
		}
		
		return new ResponseEntity<User>( this.userService.findByLogin(login), HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>( this.userService.create(user), HttpStatus.CREATED );
	}
}
