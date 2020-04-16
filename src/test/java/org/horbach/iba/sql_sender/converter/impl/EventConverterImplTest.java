package org.horbach.iba.sql_sender.converter.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.horbach.iba.sql_sender.converter.EventConverter;
import org.horbach.iba.sql_sender.dto.EventDTO;
import org.horbach.iba.sql_sender.entity.Event;
import org.horbach.iba.sql_sender.entity.Location;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/context/converter-context/converter-context.xml" })
class EventConverterImplTest {

	@Autowired
	private EventConverter eventConverter;

	private static EventDTO eventDTO;

	private static Event event;

	@BeforeAll
	static void setUp() {
		setUpEventDTO();
		setUpEvent();
	}

	static void setUpEventDTO() {
		eventDTO = new EventDTO(1, "Too much", "Festival", LocalDateTime.of(2007, 12, 03, 10, 15, 30), new Location(),
				20);
	}

	static void setUpEvent() {
		event = new Event(1, "Too much", "Festival", LocalDateTime.of(2007, 12, 03, 10, 15, 30), new Location(), 20);
	}

	@Test
	void testSuccessConvertEventToEventDTO() {
		assertThat(eventDTO, equalTo(eventConverter.convertEventToEventDTO(event)));
	}

	@Test
	void testSuccessConvertEventDTOToEvent() {
		System.out.println();
		assertThat(event, equalTo(eventConverter.convertEventDTOToEvent(eventDTO)));
	}

}
