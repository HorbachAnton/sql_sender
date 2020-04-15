package org.horbach.iba.sql_sender.dao;

import java.util.List;

import org.horbach.iba.sql_sender.entity.Event;

public interface EventDAO {

	Event getEvent(int id);

	List<Event> getEvents();

	void saveEvent(Event event);

	void updateEvent(Event event);

	void deleteEvent(Event event);

}
