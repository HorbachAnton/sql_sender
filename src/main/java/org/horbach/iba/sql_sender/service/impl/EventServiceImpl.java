package org.horbach.iba.sql_sender.service.impl;

import java.util.List;

import org.horbach.iba.sql_sender.dao.EventDAO;
import org.horbach.iba.sql_sender.entity.Event;
import org.horbach.iba.sql_sender.service.EventService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EventServiceImpl implements EventService {

	EventDAO eventDAO;

	public EventServiceImpl() {

	}

	public EventServiceImpl(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	@Override
	public Event getEvent(int id) {
		return eventDAO.getEvent(id);
	}

	@Override
	public List<Event> getEvents() {
		return eventDAO.getEvents();
	}

	@Override
	public void saveEvent(Event event) {
		eventDAO.saveEvent(event);
	}

	@Override
	public void updateEvent(Event event) {
		eventDAO.updateEvent(event);
	}

	@Override
	public void deleteEvent(Event event) {
		eventDAO.deleteEvent(event);
	}

}
