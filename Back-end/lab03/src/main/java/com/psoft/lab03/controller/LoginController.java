package com.psoft.lab03.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.psoft.lab03.Exception.LoginIncorrect;
import com.psoft.lab03.Exception.user.UserNotFound;
import com.psoft.lab03.model.LoginResponse;
import com.psoft.lab03.model.User;
import com.psoft.lab03.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping({"/v1/login"})
public class LoginController {

	private final String TOKEN_KEY = "bananas";
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(value = "/")
	@ResponseBody
	private LoginResponse authenticate(@RequestBody User user) {
		User u = this.userService.findByLogin(user.getLogin());
		
		if (u == null) {
			throw new UserNotFound("Usuário não cadastrado!");
		}
		
		if (!(u.getSenha().equals(user.getSenha()))) {
			throw new LoginIncorrect("Autenticação incorreta!");
		}
		
		String token = Jwts.builder().
				setSubject(u.getLogin()).
				signWith(SignatureAlgorithm.HS512, TOKEN_KEY).
				setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();

		return new LoginResponse(token);
	}
	
}
