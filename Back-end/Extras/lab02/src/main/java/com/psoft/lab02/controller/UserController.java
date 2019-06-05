package com.psoft.lab02.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.psoft.lab02.model.Usuario;
import com.psoft.lab02.service.UserService;

@RestController
@RequestMapping({"/v1/usuarios"})
public class UserController {

	private UserService usuarioService;
	
	public UserController(UserService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(value = "/{login}")
	@ResponseBody
	public ResponseEntity<Usuario> getUsuario(@PathVariable String login) {
		return new ResponseEntity<Usuario>( this.usuarioService.findByLogin(login), HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>( this.usuarioService.create(usuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/")
	@ResponseBody
	public ResponseEntity delete() {
		this.usuarioService.deleteAll();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	@ResponseBody
	public ResponseEntity<List<Usuario>> getUsuario() {
		return new ResponseEntity<List<Usuario>>( this.usuarioService.findAll(), HttpStatus.OK);
	}
	
}
