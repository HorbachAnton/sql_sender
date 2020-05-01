package org.horbach.iba.sql_sender.facade;

import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.dto.RequestResultDTO;

public interface RequestFacade {

	RequestResultDTO executeRequest(RequestDTO request);

}
