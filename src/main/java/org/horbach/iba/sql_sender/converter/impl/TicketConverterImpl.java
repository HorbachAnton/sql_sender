package org.horbach.iba.sql_sender.converter.impl;

import org.horbach.iba.sql_sender.converter.TicketConverter;
import org.horbach.iba.sql_sender.dto.TicketDTO;
import org.horbach.iba.sql_sender.entity.Ticket;

public class TicketConverterImpl implements TicketConverter {

	@Override
	public TicketDTO convertTicketToTicketDTO(Ticket ticket) {
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setId(ticket.getId());
		ticketDTO.setUser(ticket.getUser());
		ticketDTO.setEvent(ticket.getEvent());
		return ticketDTO;
	}

	@Override
	public Ticket convertTicketDTOToTicket(TicketDTO ticketDTO) {
		Ticket ticket = new Ticket();
		ticket.setId(ticketDTO.getId());
		ticket.setUser(ticketDTO.getUser());
		ticket.setEvent(ticketDTO.getEvent());
		return ticket;
	}

}
