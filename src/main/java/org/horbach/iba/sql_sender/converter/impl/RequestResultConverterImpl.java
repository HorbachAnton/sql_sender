package org.horbach.iba.sql_sender.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.horbach.iba.sql_sender.converter.RequestResultConverter;
import org.horbach.iba.sql_sender.dto.RequestResultDTO;
import org.horbach.iba.sql_sender.entity.RequestResult;

public class RequestResultConverterImpl implements RequestResultConverter {

	@Override
	public RequestResultDTO convertRequestResultToRequestResultDTO(RequestResult requestResult) {
		RequestResultDTO requestResultDTO = new RequestResultDTO();
		requestResultDTO.setId(requestResult.getId());
		requestResultDTO.setMessage(requestResult.getMessage());
		if (requestResult.getRequestedData() != null && !requestResult.getRequestedData().isEmpty()) {
			requestResultDTO.setRequestedData(convertToListStringArrays(requestResult.getRequestedData()));
		}
		return requestResultDTO;
	}

	@Override
	public RequestResult convertRequestResultDTOToRequestResult(RequestResultDTO requestResultDTO) {
		RequestResult requestResult = new RequestResult();
		requestResult.setId(requestResultDTO.getId());
		requestResult.setMessage(requestResultDTO.getMessage());
		return requestResult;
	}

	private static List<String[]> convertToListStringArrays(List<Object[]> requestedData) {
		List<String[]> targetRequestedData = new ArrayList<>(requestedData.size());
		ArrayConverter converter = new ArrayConverter(Object[].class, new StringConverter());
		for (Object[] array : requestedData) {
			targetRequestedData.add(converter.convert(String[].class, array));
		}
		return targetRequestedData;
	}

}
