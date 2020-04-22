package org.horbach.iba.sql_sender.facade;

import org.horbach.iba.sql_sender.dto.RequestDTO;

public interface RequestFacade {
	
	void executeRequest(RequestDTO request);

}
