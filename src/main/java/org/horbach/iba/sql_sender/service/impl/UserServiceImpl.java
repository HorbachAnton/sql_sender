package org.horbach.iba.sql_sender.service.impl;

import java.util.List;

import org.horbach.iba.sql_sender.dao.UserDAO;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.entity.enumeration.UserRoles;
import org.horbach.iba.sql_sender.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	private PasswordEncoder passwordEncoder;

	public UserServiceImpl() {

	}

	public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
		this.userDAO = userDAO;
		this.passwordEncoder = passwordEncoder;
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
		setUpDefaultUser(user);
		userDAO.saveUser(user);
	}

	private void setUpDefaultUser(User user) {
		user.setPassword(encodePassword(user.getPassword()));
		user.setEnabled(true);
		user.setUserRole(UserRoles.USER);
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

	@Override
	public boolean isCurrentUser(User user) {
		return getCurrentUser().equals(user);
	}

	@Override
	public User getCurrentUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();

		if (!isAuthenticated(authentication)) {
			return null;
		}

		return userDAO.getUser(authentication.getName());
	}

	@Override
	public boolean isAuthenticated(Authentication authentication) {
		return authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
				&& authentication.isAuthenticated();
	}

}
