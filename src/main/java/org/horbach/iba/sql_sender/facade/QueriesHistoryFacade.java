package org.horbach.iba.sql_sender.facade;

import java.util.List;

import org.horbach.iba.sql_sender.dto.RequestDTO;

public interface QueriesHistoryFacade {
	
	List<RequestDTO> getUserRequests();

}
