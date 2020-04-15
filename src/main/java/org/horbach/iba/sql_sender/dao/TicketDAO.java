package org.horbach.iba.sql_sender.dao;

import java.util.List;

import org.horbach.iba.sql_sender.entity.Ticket;

public interface TicketDAO {
	
	Ticket getTicket(int id);
	
	List<Ticket> getTickets();
	
	void saveTicket(Ticket ticket);
	
	void updateTicket(Ticket ticket);
	
	void deleteTicket(Ticket ticket);

}
