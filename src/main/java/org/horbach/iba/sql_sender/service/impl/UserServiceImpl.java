package org.horbach.iba.sql_sender.service.impl;

import java.util.List;

import org.horbach.iba.sql_sender.dao.UserDAO;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public UserServiceImpl() {

	}

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getUser(String username) {
		return userDAO.getUser(username);
	}
	
	@Override
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public void registerUser(User user) {
		userDAO.saveUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

}
