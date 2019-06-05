package com.psoft.lab02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psoft.lab02.model.Usuario;

@Repository
public interface UserDAO extends CrudRepository<Usuario, String>{

	public Usuario save(Usuario usuario);
	
	public Usuario findByLogin(String login);
	
	public void deleteAll();
	
	public List<Usuario> findAll();

}
