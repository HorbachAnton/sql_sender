package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.RequestDAO;
import org.horbach.iba.sql_sender.entity.Request;
import org.horbach.iba.sql_sender.entity.RequestResult;
import org.horbach.iba.sql_sender.entity.enumeration.RequestTypes;

public class RequestDAOImpl extends AbstractBasicDAOImpl implements RequestDAO {

	private static final String GET_REQUESTS_QUERY = "select * from request";
	private static final String GET_USER_REQUESTS_QUERY = "select * from request where user_id = ?";

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
		return getCurrentSession().createSQLQuery(GET_REQUESTS_QUERY).addEntity(Request.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getUserRequests(int userID) {
		return getCurrentSession().createSQLQuery(GET_USER_REQUESTS_QUERY).addEntity(Request.class)
				.setParameter(1, userID).list();
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

	@SuppressWarnings("unchecked")
	private RequestResult executeSelectRequest(Request request, String message) {
		RequestResult requestResult = null;
		try {
			List<Object[]> requestedData = getCurrentSession().createNativeQuery(request.getText()).list();
			requestResult = getExecutedRequestResult(requestedData.size(), message);
			requestResult.setRequestedData(requestedData);
		} catch (Exception exception) {
			requestResult = new RequestResult(0, exception.getMessage());
		}

		return requestResult;
	}

	private RequestResult executeUpdatesRequest(Request request, String message) {
		RequestResult requestResult = null;
		try {
			int numberColumns = getCurrentSession().createSQLQuery(request.getText()).executeUpdate();
			requestResult = getExecutedRequestResult(numberColumns, message);
		} catch (Exception exception) {
			requestResult = new RequestResult(0, exception.getMessage());
		}
		return requestResult;
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
