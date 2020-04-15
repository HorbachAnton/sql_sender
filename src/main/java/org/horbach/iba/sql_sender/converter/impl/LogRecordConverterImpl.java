package org.horbach.iba.sql_sender.converter.impl;

import org.horbach.iba.sql_sender.converter.LogRecordConverter;
import org.horbach.iba.sql_sender.dto.LogRecordDTO;
import org.horbach.iba.sql_sender.entity.LogRecord;

public class LogRecordConverterImpl implements LogRecordConverter {

	@Override
	public LogRecordDTO convertLogRecordToLogRecordDTO(LogRecord logRecord) {
		LogRecordDTO logRecordDTO = new LogRecordDTO();
		logRecordDTO.setId(logRecord.getId());
		logRecordDTO.setRequest(logRecord.getRequest());
		return logRecordDTO;
	}

	@Override
	public LogRecord convertLogRecordDTOToLogRecord(LogRecordDTO logRecordDTO) {
		LogRecord logRecord = new LogRecord();
		logRecord.setId(logRecordDTO.getId());
		logRecord.setRequest(logRecordDTO.getRequest());
		return logRecord;
	}

}
