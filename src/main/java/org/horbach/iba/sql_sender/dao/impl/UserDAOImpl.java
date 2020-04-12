package org.horbach.iba.sql_sender.dao.impl;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.UserDAO;
import org.horbach.iba.sql_sender.entity.User;

public class UserDAOImpl extends AbstractBasicDAOImpl implements UserDAO {

	private static final String QUERY_USER_BY_USERNAME = "select * from User where username = ?";
	private static final int USERNAME_PARAMETER_POSITION = 1;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUser(String username) {
		return (User) getCurrentSession().createSQLQuery(QUERY_USER_BY_USERNAME).addEntity(User.class)
				.setParameter(USERNAME_PARAMETER_POSITION, username).getSingleResult();
	}

}
