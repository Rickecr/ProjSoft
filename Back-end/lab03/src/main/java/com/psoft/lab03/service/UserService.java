package com.psoft.lab03.service;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import com.psoft.lab03.dao.UserDAO;
import com.psoft.lab03.model.User;

@Service
public class UserService {

	private final UserDAO userDAO;

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User create(User user) throws ServletException {
		User u = this.userDAO.findByLogin(user.getLogin());

		if (u != null) {
			throw new ServletException("Usuário ja existe!");
		}

		return this.userDAO.save(user);
	}

	public User findByLogin(String login) {
		return this.userDAO.findByLogin(login);
	}

	public List<User> findAll() {
		return this.userDAO.findAll();
	}
}