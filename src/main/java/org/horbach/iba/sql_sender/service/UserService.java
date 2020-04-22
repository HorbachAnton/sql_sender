package org.horbach.iba.sql_sender.service;

import java.util.List;

import org.horbach.iba.sql_sender.entity.User;
import org.springframework.security.core.Authentication;

public interface UserService {

	User getUser(String username);

	User getUser(int id);

	List<User> getUsers();

	void registerUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	User getCurrentUser();

	boolean isAuthenticated(Authentication authentication);

	boolean isCurrentUser(User user);

}
