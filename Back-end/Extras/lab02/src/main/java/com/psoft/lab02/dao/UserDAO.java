package com.psoft.lab02.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psoft.lab02.model.User;

@Repository
public interface UserDAO<T, ID extends Serializable> extends JpaRepository<User, Long> {

	public User save(User user);
	
	public User findById(long id);

	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User usersForName(String username);
	
}
