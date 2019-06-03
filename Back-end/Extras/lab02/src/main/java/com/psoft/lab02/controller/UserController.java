package com.psoft.lab02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.psoft.lab02.model.User;
import com.psoft.lab02.service.UserService;

@RestController
@RequestMapping({"/v1/users"})
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable long id) {
		return new ResponseEntity<User>( this.userService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>( this.userService.create(user), HttpStatus.CREATED);
	}

}
