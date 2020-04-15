package org.horbach.iba.sql_sender.converter;

import org.horbach.iba.sql_sender.dto.TicketDTO;
import org.horbach.iba.sql_sender.entity.Ticket;

public interface TicketConverter {

	TicketDTO convertTicketToTicketDTO(Ticket ticket);

	Ticket convertTicketDTOToTicket(TicketDTO ticketDTO);

}
