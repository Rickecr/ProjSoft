package com.psoft.lab03.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.psoft.lab03.model.User;

@Repository
public interface UserDAO extends JpaRepository<User, String>{

	public User save(User user);
	
	@Query("SELECT u FROM User u WHERE u.login = :plogin")
	public User findByLogin(@Param("plogin") String login);
	
	public List<User> findAll();
	
}
