package org.horbach.iba.sql_sender.converter.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.horbach.iba.sql_sender.converter.LogRecordConverter;
import org.horbach.iba.sql_sender.dto.LogRecordDTO;
import org.horbach.iba.sql_sender.entity.LogRecord;
import org.horbach.iba.sql_sender.entity.Request;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/context/converter-context/converter-context.xml" })
class LogRecordConverterImplTest {

	@Autowired
	private LogRecordConverter logRecordConverter;

	private static LogRecordDTO logRecordDTO;

	private static LogRecord logRecord;

	@BeforeAll
	static void setUp() throws Exception {
		setUpLogRecordDTO();
		setUpLogRecord();
	}

	static void setUpLogRecordDTO() {
		logRecordDTO = new LogRecordDTO(1, new Request());
	}

	static void setUpLogRecord() {
		logRecord = new LogRecord(1, new Request());
	}

	@Test
	void testSuccessConvertLogRecordToLogRecordDTO() {
		assertThat(logRecordDTO, equalTo(logRecordConverter.convertLogRecordToLogRecordDTO(logRecord)));
	}

	@Test
	void testSuccessConvertLogRecordDTOToLogRecord() {
		assertThat(logRecord, equalTo(logRecordConverter.convertLogRecordDTOToLogRecord(logRecordDTO)));
	}

}
