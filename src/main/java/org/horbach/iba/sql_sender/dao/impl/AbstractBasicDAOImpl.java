package org.horbach.iba.sql_sender.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.BasicDAO;

public abstract class AbstractBasicDAOImpl implements BasicDAO {

	protected SessionFactory sessionFactory;
	
	public AbstractBasicDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
