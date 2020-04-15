package org.horbach.iba.sql_sender.converter;

import org.horbach.iba.sql_sender.dto.EventDTO;
import org.horbach.iba.sql_sender.entity.Event;

public interface EventConverter {
	
	EventDTO convertEventToEventDTO(Event event);
	
	Event convertEventDTOToEvent(EventDTO eventDTO);

}
