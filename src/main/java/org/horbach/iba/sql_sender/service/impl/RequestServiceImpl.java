package org.horbach.iba.sql_sender.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.horbach.iba.sql_sender.dao.RequestDAO;
import org.horbach.iba.sql_sender.entity.Request;
import org.horbach.iba.sql_sender.entity.RequestResult;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.entity.enumeration.RequestTypes;
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
		return requestDAO.getRequests();
	}

	@Override
	public List<Request> getUserRequests(User user) {
		return requestDAO.getUserRequests(user.getId());
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

	@Override
	public RequestResult executeRequest(Request request) {
		prepareExecutedRequest(request);
		return requestDAO.executeRequest(request);
	}

	private void prepareExecutedRequest(Request request) {
		request.setRequestType(defineExecutedRequestType(request.getText()));
		request.setExecuteDate(LocalDateTime.now());
	}

	private RequestTypes defineExecutedRequestType(String requestText) {
		String requestCommand = StringUtils.substringBefore(requestText.trim(), " ");
		return Arrays.stream(RequestTypes.values()).filter(b -> b.toString().equalsIgnoreCase(requestCommand))
				.findFirst().orElse(RequestTypes.UNDEFINED);
	}

}
