package org.horbach.iba.sql_sender.dao;

import java.util.List;

import org.horbach.iba.sql_sender.entity.User;

public interface UserDAO {

	User getUser(String username);
	
	User getUser(int id);

	List<User> getUsers();

	void saveUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

}
