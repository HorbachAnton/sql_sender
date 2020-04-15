package org.horbach.iba.sql_sender.service;

import java.util.List;

import org.horbach.iba.sql_sender.entity.Ticket;

public interface TicketService {
	
	Ticket getTicket(int id);
	
	List<Ticket> getTickets();
	
	void saveTicket(Ticket ticket);
	
	void updateTicket(Ticket ticket);
	
	void deleteTicket(Ticket ticket);

}
