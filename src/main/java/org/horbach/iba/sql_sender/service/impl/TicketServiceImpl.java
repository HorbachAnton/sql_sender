package org.horbach.iba.sql_sender.service.impl;

import java.util.List;

import org.horbach.iba.sql_sender.dao.TicketDAO;
import org.horbach.iba.sql_sender.entity.Ticket;
import org.horbach.iba.sql_sender.service.TicketService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TicketServiceImpl implements TicketService {

	TicketDAO ticketDAO;

	public TicketServiceImpl() {

	}

	public TicketServiceImpl(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}

	@Override
	public Ticket getTicket(int id) {
		return ticketDAO.getTicket(id);
	}

	@Override
	public List<Ticket> getTickets() {
		return ticketDAO.getTickets();
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketDAO.saveTicket(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		ticketDAO.updateTicket(ticket);
	}

	@Override
	public void deleteTicket(Ticket ticket) {
		ticketDAO.deleteTicket(ticket);
	}

}
