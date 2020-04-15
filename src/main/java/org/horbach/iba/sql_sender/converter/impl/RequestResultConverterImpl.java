package org.horbach.iba.sql_sender.converter.impl;

import org.horbach.iba.sql_sender.converter.RequestResultConverter;
import org.horbach.iba.sql_sender.dto.RequestResultDTO;
import org.horbach.iba.sql_sender.entity.RequestResult;

public class RequestResultConverterImpl implements RequestResultConverter {

	@Override
	public RequestResultDTO convertRequestResultToRequestResultDTO(RequestResult requestResult) {
		RequestResultDTO requestResultDTO = new RequestResultDTO();
		requestResultDTO.setId(requestResult.getId());
		requestResultDTO.setMessage(requestResult.getMessage());
		return requestResultDTO;
	}

	@Override
	public RequestResult convertRequestResultDTOToRequestResult(RequestResultDTO requestResultDTO) {
		RequestResult requestResult = new RequestResult();
		requestResult.setId(requestResultDTO.getId());
		requestResult.setMessage(requestResultDTO.getMessage());
		return null;
	}

}
