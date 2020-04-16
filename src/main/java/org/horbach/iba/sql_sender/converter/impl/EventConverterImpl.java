package org.horbach.iba.sql_sender.converter.impl;

import org.horbach.iba.sql_sender.converter.EventConverter;
import org.horbach.iba.sql_sender.dto.EventDTO;
import org.horbach.iba.sql_sender.entity.Event;

public class EventConverterImpl implements EventConverter {

	@Override
	public EventDTO convertEventToEventDTO(Event event) {
		EventDTO eventDTO = new EventDTO();
		eventDTO.setId(event.getId());
		eventDTO.setTitle(event.getTitle());
		eventDTO.setSummary(event.getSummary());
		eventDTO.setDate(event.getDate());
		eventDTO.setLocation(event.getLocation());
		eventDTO.setPrice(event.getPrice());
		return eventDTO;
	}

	@Override
	public Event convertEventDTOToEvent(EventDTO eventDTO) {
		Event event = new Event();
		event.setId(eventDTO.getId());
		event.setTitle(eventDTO.getTitle());
		event.setSummary(eventDTO.getSummary());
		event.setDate(eventDTO.getDate());
		event.setLocation(eventDTO.getLocation());
		event.setPrice(eventDTO.getPrice());
		return event;
	}

}
