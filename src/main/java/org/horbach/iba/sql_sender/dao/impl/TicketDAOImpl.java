package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.TicketDAO;
import org.horbach.iba.sql_sender.entity.Ticket;

public class TicketDAOImpl extends AbstractBasicDAOImpl implements TicketDAO {
	
	private static final String GET_TICKETS_QUERY = "SELECT * FROM ticket";
	
	public TicketDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Ticket getTicket(int id) {
		return (Ticket) getById(Ticket.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTickets() {
		return getCurrentSession().createSQLQuery(GET_TICKETS_QUERY).addEntity(Ticket.class).list();
	}

	@Override
	public void saveTicket(Ticket ticket) {
		save(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		update(ticket);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		delete(ticket);
	}

}
