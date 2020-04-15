package org.horbach.iba.sql_sender.service.impl;

import java.util.List;

import org.horbach.iba.sql_sender.dao.RequestDAO;
import org.horbach.iba.sql_sender.entity.Request;
import org.horbach.iba.sql_sender.service.RequestService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RequestServiceImpl implements RequestService {

	RequestDAO requestDAO;

	public RequestServiceImpl() {

	}

	public RequestServiceImpl(RequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}

	@Override
	public Request getRequest(int id) {
		return requestDAO.getRequest(id);
	}

	@Override
	public List<Request> getRequests() {
		return requestDAO.getRequest();
	}

	@Override
	public void saveRequest(Request request) {
		requestDAO.saveRequest(request);
	}

	@Override
	public void updateRequest(Request request) {
		requestDAO.updateRequest(request);
	}

	@Override
	public void deleteRequest(Request request) {
		requestDAO.deleteRequest(request);
	}

}
