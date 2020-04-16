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
import org.horbach.iba.sql_sender.dao.RequestResultDAO;

import org.horbach.iba.sql_sender.entity.RequestResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RequestResultServiceImplTest {

	@Mock
	private static RequestResultDAO requestResultDAO;

	private static RequestResult expectedRequestResult;

	private static List<RequestResult> expectedRequestResults;

	private static RequestResultServiceImpl requestResultServiceImpl;

	@BeforeAll
	static void setUp() throws Exception {
		setUpExpectedRequestResult();
		setUpExpectedRequestResults();
		setUpRequestResultDAO();
		setUpRequestResultServiceImpl();
	}

	static void setUpExpectedRequestResult() {
		expectedRequestResult = new RequestResult(1, "Success");
	}

	static void setUpExpectedRequestResults() {
		expectedRequestResults = new ArrayList<RequestResult>(
				Arrays.asList(expectedRequestResult, new RequestResult()));
	}

	static void setUpRequestResultDAO() {
		requestResultDAO = mock(RequestResultDAO.class);
		doReturn(expectedRequestResult).when(requestResultDAO).getRequestResult(1);
		doReturn(expectedRequestResults).when(requestResultDAO).getRequestResults();
	}

	static void setUpRequestResultServiceImpl() {
		requestResultServiceImpl = new RequestResultServiceImpl(requestResultDAO);
	}

	@Test
	void testSuccessGetRequestResult() {
		RequestResult receivedRequestResult = requestResultServiceImpl.getRequestResult(1);
		assertThat(expectedRequestResult, allOf(sameInstance(receivedRequestResult), equalTo(receivedRequestResult)));
	}

	@Test
	void testSuccessGetRequestResults() {
		List<RequestResult> receivedRequestResults = requestResultServiceImpl.getRequestResults();
		assertThat(expectedRequestResults,
				allOf(sameInstance(receivedRequestResults), equalTo(receivedRequestResults)));
	}

}
