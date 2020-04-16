package org.horbach.iba.sql_sender.converter.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.horbach.iba.sql_sender.converter.TicketConverter;
import org.horbach.iba.sql_sender.dto.TicketDTO;
import org.horbach.iba.sql_sender.entity.Event;
import org.horbach.iba.sql_sender.entity.Ticket;
import org.horbach.iba.sql_sender.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/context/converter-context/converter-context.xml" })
class TicketConverterImplTest {

	@Autowired
	private TicketConverter ticketConverter;

	private static Ticket ticket;

	private static TicketDTO ticketDTO;

	@BeforeAll
	static void setUp() throws Exception {
		setUpTicket();
		setUpTicketDTO();
	}

	static void setUpTicket() {
		ticket = new Ticket(1, new User(), new Event());
	}

	static void setUpTicketDTO() {
		ticketDTO = new TicketDTO(1, new User(), new Event());
	}

	@Test
	void testSuccessConvertTicketToTicketDTO() {
		assertThat(ticketDTO, equalTo(ticketConverter.convertTicketToTicketDTO(ticket)));
	}

	@Test
	void testSuccessConvertTickeDTOtToTicket() {
		assertThat(ticket, equalTo(ticketConverter.convertTicketDTOToTicket(ticketDTO)));
	}

}
