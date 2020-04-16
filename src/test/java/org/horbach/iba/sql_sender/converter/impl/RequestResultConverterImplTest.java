package org.horbach.iba.sql_sender.converter.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.horbach.iba.sql_sender.converter.RequestResultConverter;
import org.horbach.iba.sql_sender.dto.RequestResultDTO;
import org.horbach.iba.sql_sender.entity.RequestResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/context/converter-context/converter-context.xml" })
class RequestResultConverterImplTest {

	@Autowired
	private RequestResultConverter requestResultConverter;

	private static RequestResult requestResult;

	private static RequestResultDTO requestResultDTO;

	@BeforeAll
	static void setUp() throws Exception {
		setUpRequestResult();
		setUpRequestResultDTO();
	}

	static void setUpRequestResult() {
		requestResult = new RequestResult(1, "Success");
	}

	static void setUpRequestResultDTO() {
		requestResultDTO = new RequestResultDTO(1, "Success");
	}

	@Test
	void testSuccessConvertRequestResultToRequestResultDTO() {
		assertThat(requestResultDTO,
				equalTo(requestResultConverter.convertRequestResultToRequestResultDTO(requestResult)));
	}

	@Test
	void testSuccessConvertRequestResultDTOToRequestResult() {
		assertThat(requestResult,
				equalTo(requestResultConverter.convertRequestResultDTOToRequestResult(requestResultDTO)));
	}

}
