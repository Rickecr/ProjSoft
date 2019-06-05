package com.psoft.lab02.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.psoft.lab02.dao.UserDAO;
import com.psoft.lab02.model.Usuario;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioDAO.findByLogin(login);
		if (usuario == null) {
			throw new UsernameNotFoundException("Username não encontrado!");
		}
		
		return usuario;
	}

}
