package org.horbach.iba.sql_sender.service.impl;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.horbach.iba.sql_sender.dao.EventDAO;
import org.horbach.iba.sql_sender.dao.impl.EventDAOImpl;
import org.horbach.iba.sql_sender.entity.Event;
import org.horbach.iba.sql_sender.entity.Location;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

	@Mock
	private static EventDAO eventDAO;

	private static Event expectedEvent;

	private static List<Event> expectedEvents;

	private static EventServiceImpl eventServiceImpl;

	@BeforeAll
	static void setUp() throws Exception {
		setUpExpectedEvent();
		setUpExpectedEvents();
		setUpEventDAO();
		setUpEventServiceImpl();
	}

	static void setUpExpectedEvent() {
		expectedEvent = new Event(1, "Too much", "Festival", LocalDateTime.of(2007, 12, 03, 10, 15, 30), new Location(),
				20);
	}

	static void setUpExpectedEvents() {
		expectedEvents = new ArrayList<Event>(Arrays.asList(expectedEvent, new Event()));
	}

	static void setUpEventDAO() {
		eventDAO = mock(EventDAOImpl.class);
		doReturn(expectedEvent).when(eventDAO).getEvent(1);
		doReturn(expectedEvents).when(eventDAO).getEvents();
	}

	static void setUpEventServiceImpl() {
		eventServiceImpl = new EventServiceImpl(eventDAO);
	}

	@Test
	void testSuccessGetEvent() {
		Event receivedEvent = eventServiceImpl.getEvent(1);
		assertThat(expectedEvent, allOf(sameInstance(receivedEvent), equalTo(receivedEvent)));
	}

	@Test
	void testSuccessGetEvents() {
		List<Event> receivedEvents = eventServiceImpl.getEvents();
		assertThat(expectedEvents, allOf(sameInstance(receivedEvents), equalTo(receivedEvents)));
	}

}
