package org.horbach.iba.sql_sender.facade.impl;

import org.horbach.iba.sql_sender.converter.RequestConverter;
import org.horbach.iba.sql_sender.converter.RequestResultConverter;
import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.dto.RequestResultDTO;
import org.horbach.iba.sql_sender.entity.LogRecord;
import org.horbach.iba.sql_sender.entity.Request;
import org.horbach.iba.sql_sender.entity.RequestResult;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.facade.RequestFacade;
import org.horbach.iba.sql_sender.service.LogRecordService;
import org.horbach.iba.sql_sender.service.RequestResultService;
import org.horbach.iba.sql_sender.service.RequestService;
import org.horbach.iba.sql_sender.service.UserService;

public class RequestFacadeImpl implements RequestFacade {

	private RequestConverter requestConverter;
	private RequestService requestService;
	private UserService userService;
	private RequestResultService requestResultService;
	private LogRecordService logRecordService;
	private RequestResultConverter requestResultConverter;

	public RequestFacadeImpl() {

	}

	public RequestFacadeImpl(RequestConverter requestConverter, RequestService requestService, UserService userService,
			RequestResultService requestResultService, LogRecordService logRecordService,
			RequestResultConverter requestResultConverter) {
		super();
		this.requestConverter = requestConverter;
		this.requestService = requestService;
		this.userService = userService;
		this.requestResultService = requestResultService;
		this.logRecordService = logRecordService;
		this.requestResultConverter = requestResultConverter;
	}

	public RequestResultDTO executeRequest(RequestDTO requestDTO) {
		Request request = requestConverter.convertRequestDTOToRequest(requestDTO);
		request.setUser(getCurrentUser());
		RequestResult requestResult = requestService.executeRequest(request);
		requestResultService.saveRequestResult(requestResult);
		request.setResult(requestResult);
		requestService.saveRequest(request);
		logRecordService.saveLogRecord(new LogRecord(0, request));
		return requestResultConverter.convertRequestResultToRequestResultDTO(requestResult);
	}

	private User getCurrentUser() {
		return userService.getCurrentUser();
	}

}
