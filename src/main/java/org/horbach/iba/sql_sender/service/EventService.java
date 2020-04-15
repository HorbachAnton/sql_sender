package org.horbach.iba.sql_sender.service;

import java.util.List;

import org.horbach.iba.sql_sender.entity.Event;

public interface EventService {

	Event getEvent(int id);

	List<Event> getEvents();

	void saveEvent(Event event);

	void updateEvent(Event event);

	void deleteEvent(Event evet);

}
