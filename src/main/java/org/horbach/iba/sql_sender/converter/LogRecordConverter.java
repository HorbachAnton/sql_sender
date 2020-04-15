package org.horbach.iba.sql_sender.converter;

import org.horbach.iba.sql_sender.dto.LogRecordDTO;
import org.horbach.iba.sql_sender.entity.LogRecord;

public interface LogRecordConverter {

	LogRecordDTO convertLogRecordToLogRecordDTO(LogRecord logRecord);

	LogRecord convertLogRecordDTOToLogRecord(LogRecordDTO logRecordDTO);

}
