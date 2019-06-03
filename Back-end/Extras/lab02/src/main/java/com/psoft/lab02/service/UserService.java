package com.psoft.lab02.service;

import org.springframework.stereotype.Service;

import com.psoft.lab02.dao.UserDAO;
import com.psoft.lab02.model.User;

@Service
public class UserService {

	private UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User create(User user) {
		if (user.getUsername() != null && user.getPassword() != null) {
			User u = this.userDAO.usersForName(user.getUsername());
			if (u != null) {
				throw new InternalError("Erro.");
			} else {
				return this.userDAO.save(user);
			}			
		} else {
			throw new InternalError("Erro.");
		}
	}
	
	public User findById(long id) {
		return this.userDAO.findById(id);
	}
	
	public void delete(long id) {
		this.userDAO.deleteById(id);
	}
	
	public User update(User userToUpdate) {
		User u = this.userDAO.findById(userToUpdate.getId());
		
		if (u == null) {
			// Exceção.
		}
		
		return this.userDAO.save(userToUpdate);
	}
}
