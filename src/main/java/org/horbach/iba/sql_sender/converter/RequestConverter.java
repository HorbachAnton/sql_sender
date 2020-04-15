package org.horbach.iba.sql_sender.converter;

import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.entity.Request;

public interface RequestConverter {

	RequestDTO convertRequestToRequestDTO(Request request);

	Request convertRequestDTOToRequest(RequestDTO requestDTO);

}
