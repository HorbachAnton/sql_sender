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

import org.horbach.iba.sql_sender.dao.RequestDAO;
import org.horbach.iba.sql_sender.dao.impl.RequestDAOImpl;
import org.horbach.iba.sql_sender.entity.Request;
import org.horbach.iba.sql_sender.entity.RequestResult;
import org.horbach.iba.sql_sender.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RequestServiceImplTest {

	@Mock
	private static RequestDAO requestDAO;

	private static Request expectedRequest;

	private static List<Request> expectedRequests;

	private static RequestServiceImpl requestServiceImpl;

	@BeforeAll
	static void setUp() throws Exception {
		setUpExpectedRequest();
		setUpExpectedRequests();
		setUpRequestDAO();
		setUpRequestServiceImpl();
	}

	static void setUpExpectedRequest() {
		expectedRequest = new Request(1, "SELECT", LocalDateTime.of(2007, 12, 03, 10, 15, 30), new User(),
				new RequestResult());
	}

	static void setUpExpectedRequests() {
		expectedRequests = new ArrayList<Request>(Arrays.asList(expectedRequest, new Request()));
	}

	static void setUpRequestDAO() {
		requestDAO = mock(RequestDAOImpl.class);
		doReturn(expectedRequest).when(requestDAO).getRequest(1);
		doReturn(expectedRequests).when(requestDAO).getRequests();
	}

	static void setUpRequestServiceImpl() {
		requestServiceImpl = new RequestServiceImpl(requestDAO);
	}

	@Test
	void testSuccessGetRequest() {
		Request receivedRequest = requestServiceImpl.getRequest(1);
		assertThat(expectedRequest, allOf(sameInstance(receivedRequest), equalTo(receivedRequest)));
	}

	@Test
	void testsSuccessGetRequests() {
		List<Request> receivedRequests = requestServiceImpl.getRequests();
		assertThat(expectedRequests, allOf(sameInstance(receivedRequests), equalTo(receivedRequests)));
	}

}
