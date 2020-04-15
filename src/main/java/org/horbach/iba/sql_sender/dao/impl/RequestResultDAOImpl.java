package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.RequestResultDAO;
import org.horbach.iba.sql_sender.entity.RequestResult;

public class RequestResultDAOImpl extends AbstractBasicDAOImpl implements RequestResultDAO {

	private static final String GET_REQUEST_RESULT_QUERY = "select * from request_result";
	
	public RequestResultDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public RequestResult getRequestResult(int id) {
		return (RequestResult) getById(RequestResult.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestResult> getRequestResult() {
		return getCurrentSession().createSQLQuery(GET_REQUEST_RESULT_QUERY).addEntity(RequestResult.class).list();
	}

	@Override
	public void saveRequestResult(RequestResult requestResult) {
		save(requestResult);
	}

	@Override
	public void updateRequestResult(RequestResult requestResult) {
		update(requestResult);
	}

	@Override
	public void deleteRequestResult(RequestResult requestResult) {
		delete(requestResult);
	}

}
