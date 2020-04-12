package org.horbach.iba.sql_sender.dao;

import org.horbach.iba.sql_sender.entity.User;

public interface UserDAO {
	
	User getUser(String username);

}
