package com.psoft.lab02.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.psoft.lab02.dao.UserDAO;
import com.psoft.lab02.model.Usuario;

@Service
public class UserService {
	
	private UserDAO usuarioDAO;
	
	public UserService(UserDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public Usuario create(Usuario user) {
		user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
		return this.usuarioDAO.save(user);
	}
	
	public Usuario findByLogin(String login) {
		return this.usuarioDAO.findByLogin(login);
	}
	
	public void deleteAll() {
		this.usuarioDAO.deleteAll();;
	}
	
	public List<Usuario> findAll() {
		return this.usuarioDAO.findAll();
	}

}
