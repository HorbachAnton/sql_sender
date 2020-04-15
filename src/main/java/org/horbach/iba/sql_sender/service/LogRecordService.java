package org.horbach.iba.sql_sender.service;

import java.util.List;

import org.horbach.iba.sql_sender.entity.LogRecord;

public interface LogRecordService {

	LogRecord getLogRecord(int id);

	List<LogRecord> getRecords();

	void saveLogRecord(LogRecord logRecord);

	void updateLogRecord(LogRecord logRecord);

	void deleteLogRecord(LogRecord logRecord);

}
