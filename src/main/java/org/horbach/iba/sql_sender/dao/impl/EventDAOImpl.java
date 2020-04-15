package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.EventDAO;
import org.horbach.iba.sql_sender.entity.Event;
import org.horbach.iba.sql_sender.entity.Ticket;

public class EventDAOImpl extends AbstractBasicDAOImpl implements EventDAO {

	private static final String GET_EVENTS_QUERY = "select * from event";

	public EventDAOImpl() {
		
	}
	
	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Event getEvent(int id) {
		return (Event) getById(Event.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEvents() {
		return getCurrentSession().createSQLQuery(GET_EVENTS_QUERY).addEntity(Ticket.class).list();
	}

	@Override
	public void saveEvent(Event event) {
		save(event);
	}

	@Override
	public void updateEvent(Event event) {
		update(event);
	}

	@Override
	public void deleteEvent(Event event) {
		delete(event);
	}

}
