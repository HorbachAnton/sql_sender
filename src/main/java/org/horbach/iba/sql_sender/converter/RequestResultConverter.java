package org.horbach.iba.sql_sender.converter;

import org.horbach.iba.sql_sender.dto.RequestResultDTO;
import org.horbach.iba.sql_sender.entity.RequestResult;

public interface RequestResultConverter {

	RequestResultDTO convertRequestResultToRequestResultDTO(RequestResult requestResult);

	RequestResult convertRequestResultDTOToRequestResult(RequestResultDTO requestResultDTO);

}
