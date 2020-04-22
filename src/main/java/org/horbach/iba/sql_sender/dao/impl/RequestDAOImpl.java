package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.RequestDAO;
import org.horbach.iba.sql_sender.entity.Request;
import org.horbach.iba.sql_sender.entity.RequestResult;
import org.horbach.iba.sql_sender.entity.enumeration.RequestTypes;

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
	public List<Request> getRequests() {
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

	@Override
	public RequestResult executeRequest(Request request) {
		RequestResult requestResult = null;

		if (request.getRequestType().equals(RequestTypes.SELECT)) {
			requestResult = executeSelectRequest(request, "Successfully selected %d elements.");
		} else if (request.getRequestType().equals(RequestTypes.UPDATE)) {
			requestResult = executeUpdatesRequest(request, "Successfully updated %d columns.");
		} else if (request.getRequestType().equals(RequestTypes.INSERT)) {
			requestResult = executeUpdatesRequest(request, "Successfully inserted %d columns.");
		} else if (request.getRequestType().equals(RequestTypes.DELETE)) {
			requestResult = executeUpdatesRequest(request, "Successfully deleted %d columns.");
		} else if (request.getRequestType().equals(RequestTypes.CREATE)) {
			requestResult = executeDropCreateRequest(request, "Successfully created table.");
		} else if (request.getRequestType().equals(RequestTypes.DROP)) {
			requestResult = executeDropCreateRequest(request, "Successfully drop table.");
		}

		return requestResult;
	}

	private RequestResult executeSelectRequest(Request request, String message) {
		List<?> requestedData = getCurrentSession().createSQLQuery(request.getText()).getResultList();
		RequestResult requestResult = getExecutedRequestResult(requestedData.size(), message);
		requestResult.setRequestedData(requestedData);
		return requestResult;
	}

	private RequestResult executeUpdatesRequest(Request request, String message) {
		int numberColumns = getCurrentSession().createSQLQuery(request.getText()).executeUpdate();
		return getExecutedRequestResult(numberColumns, message);
	}

	private RequestResult getExecutedRequestResult(int numberColumns, String message) {
		RequestResult requestResult = new RequestResult();
		requestResult.setMessage(String.format(message, numberColumns));
		return requestResult;
	}

	private RequestResult executeDropCreateRequest(Request request, String message) {
		getCurrentSession().createSQLQuery(request.getText()).executeUpdate();
		return getExecutedRequestResult(message);
	}

	private RequestResult getExecutedRequestResult(String message) {
		RequestResult requestResult = new RequestResult();
		requestResult.setMessage(message);
		return requestResult;
	}

}
