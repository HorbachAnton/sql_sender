package org.horbach.iba.sql_sender.converter.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;

import org.horbach.iba.sql_sender.converter.RequestConverter;
import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.entity.Request;
import org.horbach.iba.sql_sender.entity.RequestResult;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.entity.enumeration.RequestTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/context/converter-context/converter-context.xml" })
class RequestConverterImplTest {

	@Autowired
	private RequestConverter requestConverter;

	private static RequestDTO requestDTO;

	private static Request request;

	@BeforeAll
	static void setUp() throws Exception {
		setUpRequestDTO();
		setUpRequest();
	}

	static void setUpRequestDTO() {
		requestDTO = new RequestDTO(1, "SELECT", RequestTypes.SELECT, LocalDateTime.of(2007, 12, 03, 10, 15, 30),
				new User(), new RequestResult());
	}

	static void setUpRequest() {
		request = new Request(1, "SELECT", RequestTypes.SELECT, LocalDateTime.of(2007, 12, 03, 10, 15, 30), new User(),
				new RequestResult());
	}

	@Test
	void testSuccessConvertRequestToRequestDTO() {
		assertThat(requestDTO, equalTo(requestConverter.convertRequestToRequestDTO(request)));
	}

	@Test
	void testSuccessConvertRequestDTOToRequest() {
		assertThat(request, equalTo(requestConverter.convertRequestDTOToRequest(requestDTO)));
	}

}
