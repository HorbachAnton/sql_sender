package org.horbach.iba.sql_sender.facade.impl;

import java.util.List;

import org.horbach.iba.sql_sender.converter.RequestListConverter;
import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.facade.QueriesHistoryFacade;
import org.horbach.iba.sql_sender.service.RequestService;
import org.horbach.iba.sql_sender.service.UserService;

public class QueriesHistoryFacadeImpl implements QueriesHistoryFacade {

	private UserService userService;
	private RequestService requestService;
	private RequestListConverter requestListConverter;

	public QueriesHistoryFacadeImpl() {

	}

	public QueriesHistoryFacadeImpl(UserService userService, RequestService requestService,
			RequestListConverter requestListConverter) {
		this.userService = userService;
		this.requestService = requestService;
		this.requestListConverter = requestListConverter;
	}

	@Override
	public List<RequestDTO> getUserRequests() {
		User user = userService.getCurrentUser();
		return requestListConverter.convertListRequestToListRequestDTO(requestService.getUserRequests(user));
	}

}
