package org.horbach.iba.sql_sender.service.impl;

import java.util.List;

import org.horbach.iba.sql_sender.dao.RequestResultDAO;
import org.horbach.iba.sql_sender.entity.RequestResult;
import org.horbach.iba.sql_sender.service.RequestResultService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RequestResultServiceImpl implements RequestResultService {

	RequestResultDAO requestResultDAO;

	public RequestResultServiceImpl() {

	}

	public RequestResultServiceImpl(RequestResultDAO requestResultDAO) {
		this.requestResultDAO = requestResultDAO;
	}

	@Override
	public RequestResult getRequestResult(int id) {
		return requestResultDAO.getRequestResult(id);
	}

	@Override
	public List<RequestResult> getRequestResults() {
		return requestResultDAO.getRequestResults();
	}

	@Override
	public void saveRequestResult(RequestResult requestResult) {
		requestResultDAO.saveRequestResult(requestResult);
	}

	@Override
	public void updateRequestResult(RequestResult requestResult) {
		requestResultDAO.updateRequestResult(requestResult);
	}

	@Override
	public void deleteRequestResult(RequestResult requestResult) {
		requestResultDAO.deleteRequestResult(requestResult);
	}

}
