package org.horbach.iba.sql_sender.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.BasicDAO;

public abstract class AbstractBasicDAOImpl implements BasicDAO {

	protected SessionFactory sessionFactory;

	public AbstractBasicDAOImpl() {

	}

	public AbstractBasicDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Object object) {
		sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void update(Object object) {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void delete(Object object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@Override
	public <T> Object getById(Class<T> expectedClass, int objectId) {
		return sessionFactory.getCurrentSession().get(expectedClass, objectId);
	}

}
