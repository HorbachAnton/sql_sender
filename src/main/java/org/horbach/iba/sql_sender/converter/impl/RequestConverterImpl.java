package org.horbach.iba.sql_sender.converter.impl;

import org.horbach.iba.sql_sender.converter.RequestConverter;
import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.entity.Request;

public class RequestConverterImpl implements RequestConverter {

	@Override
	public RequestDTO convertRequestToRequestDTO(Request request) {
		RequestDTO requestDTO = new RequestDTO();
		requestDTO.setId(request.getId());
		requestDTO.setText(request.getText());
		requestDTO.setRequestType(request.getRequestType());
		requestDTO.setExecuteDate(request.getExecuteDate());
		requestDTO.setUser(request.getUser());
		requestDTO.setResult(request.getResult());
		return requestDTO;
	}

	@Override
	public Request convertRequestDTOToRequest(RequestDTO requestDTO) {
		Request request = new Request();
		request.setId(requestDTO.getId());
		request.setText(requestDTO.getText());
		request.setRequestType(requestDTO.getRequestType());
		request.setExecuteDate(requestDTO.getExecuteDate());
		request.setUser(requestDTO.getUser());
		request.setResult(requestDTO.getResult());
		return request;
	}

}
