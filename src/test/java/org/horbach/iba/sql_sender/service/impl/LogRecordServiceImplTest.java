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

import org.horbach.iba.sql_sender.dao.LogRecordDAO;
import org.horbach.iba.sql_sender.dao.impl.LogRecordDAOImpl;
import org.horbach.iba.sql_sender.entity.LogRecord;
import org.horbach.iba.sql_sender.entity.Request;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogRecordServiceImplTest {

	@Mock
	private static LogRecordDAO logRecordDAO;

	private static LogRecord expectedLogRecord;

	private static List<LogRecord> expectedLogRecords;

	private static LogRecordServiceImpl logRecordServiceImpl;

	@BeforeAll
	static void setUp() throws Exception {
		setUpExpectedLogRecord();
		setUpExpectedLogRecords();
		setUpLogRecordDAO();
		setUpLogRecordServiceImpl();
	}

	static void setUpExpectedLogRecord() {
		expectedLogRecord = new LogRecord(1, new Request());
	}

	static void setUpExpectedLogRecords() {
		expectedLogRecords = new ArrayList<LogRecord>(Arrays.asList(expectedLogRecord, new LogRecord()));
	}

	static void setUpLogRecordDAO() {
		logRecordDAO = mock(LogRecordDAOImpl.class);
		doReturn(expectedLogRecord).when(logRecordDAO).getLogRecord(1);
		doReturn(expectedLogRecords).when(logRecordDAO).getLogRecords();

	}

	static void setUpLogRecordServiceImpl() {
		logRecordServiceImpl = new LogRecordServiceImpl(logRecordDAO);
	}

	@Test
	void testSuccessGetLogRecord() {
		LogRecord receivedLogRecord = logRecordServiceImpl.getLogRecord(1);
		assertThat(expectedLogRecord, allOf(sameInstance(receivedLogRecord), equalTo(receivedLogRecord)));
	}

	@Test
	void testSuccessGetLogRecords() {
		List<LogRecord> receivedLogRecords = logRecordServiceImpl.getLogRecords();
		assertThat(expectedLogRecords, allOf(sameInstance(receivedLogRecords), equalTo(receivedLogRecords)));
	}

}
