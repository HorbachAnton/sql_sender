package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.UserDAO;
import org.horbach.iba.sql_sender.entity.User;

public class UserDAOImpl extends AbstractBasicDAOImpl implements UserDAO {

	private static final String USER_BY_USERNAME_QUERY = "select * from User where username = ?";
	private static final int USERNAME_PARAMETER_POSITION = 1;

	private static final String GET_USERS_QUERY = "select * from User";

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUser(String username) {
		return (User) getCurrentSession().createSQLQuery(USER_BY_USERNAME_QUERY).addEntity(User.class)
				.setParameter(USERNAME_PARAMETER_POSITION, username).getSingleResult();
	}
	
	@Override
	public User getUser(int id) {
		return (User) getById(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return getCurrentSession().createSQLQuery(GET_USERS_QUERY).addEntity(User.class).list();
	}

	@Override
	public void saveUser(User user) {
		save(user);
	}

	@Override
	public void updateUser(User user) {
		update(user);
	}

	@Override
	public void deleteUser(User user) {
		delete(user);
	}

}
