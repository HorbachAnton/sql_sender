package org.horbach.iba.sql_sender.service.impl;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.horbach.iba.sql_sender.dao.TicketDAO;
import org.horbach.iba.sql_sender.entity.Event;
import org.horbach.iba.sql_sender.entity.Ticket;
import org.horbach.iba.sql_sender.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketServiceImplTest {

	@Mock
	private static TicketDAO ticketDAO;

	private static Ticket expectedTicket;

	private static List<Ticket> expectedTickets;

	private static TicketServiceImpl ticketServiceImpl;

	@BeforeAll
	static void setUp() throws Exception {
		setUpExpectedTicket();
		setUpExpectedTickets();
		setUpTicketDAO();
		setUpTicketServiceImpl();
	}

	static void setUpExpectedTicket() {
		expectedTicket = new Ticket(1, new User(), new Event());
	}

	static void setUpExpectedTickets() {
		expectedTickets = new ArrayList<Ticket>(Arrays.asList(expectedTicket, new Ticket()));
	}

	static void setUpTicketDAO() {
		ticketDAO = mock(TicketDAO.class);
		doReturn(expectedTicket).when(ticketDAO).getTicket(1);
		doReturn(expectedTickets).when(ticketDAO).getTickets();
	}

	static void setUpTicketServiceImpl() {
		ticketServiceImpl = new TicketServiceImpl(ticketDAO);
	}

	@Test
	void testSuccessGetTicket() {
		Ticket receivedTicket = ticketServiceImpl.getTicket(1);
		assertThat(expectedTicket, allOf(sameInstance(receivedTicket), equalTo(receivedTicket)));
	}

	@Test
	void testSuccessGetTickets() {
		List<Ticket> receivedTickets = ticketServiceImpl.getTickets();
		assertThat(expectedTickets, allOf(sameInstance(receivedTickets), equalTo(receivedTickets)));
	}

}
