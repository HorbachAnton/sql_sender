package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.RequestDAO;
import org.horbach.iba.sql_sender.entity.Request;

public class RequestDAOImpl extends AbstractBasicDAOImpl implements RequestDAO {

	private static final String GET_EVENTS_QUERY = "select * from request";
	
	public RequestDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Request getRequest(int id) {
		return (Request) getById(Request.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getRequest() {
		return getCurrentSession().createSQLQuery(GET_EVENTS_QUERY).addEntity(Request.class).list();
	}

	@Override
	public void saveRequest(Request request) {
		save(request);
	}

	@Override
	public void updateRequest(Request request) {
		update(request);

	}

	@Override
	public void deleteRequest(Request request) {
		delete(request);
	}

}
