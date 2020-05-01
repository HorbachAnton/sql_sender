package org.horbach.iba.sql_sender.converter;

import java.util.List;

import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.entity.Request;

public interface RequestListConverter {

	public List<RequestDTO> convertListRequestToListRequestDTO(List<Request> requests);

}
