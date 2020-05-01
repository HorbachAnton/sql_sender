package org.horbach.iba.sql_sender.converter.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.horbach.iba.sql_sender.converter.RequestListConverter;
import org.horbach.iba.sql_sender.converter.RequestConverter;
import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.entity.Request;

public class RequestListConverterImpl implements RequestListConverter {

	RequestConverter requestConverter;

	public RequestListConverterImpl() {

	}

	public RequestListConverterImpl(RequestConverter requestConverter) {
		this.requestConverter = requestConverter;
	}

	@Override
	public List<RequestDTO> convertListRequestToListRequestDTO(List<Request> requests) {
		return requests.stream().map(b -> requestConverter.convertRequestToRequestDTO(b)).collect(Collectors.toList());
	}

}
