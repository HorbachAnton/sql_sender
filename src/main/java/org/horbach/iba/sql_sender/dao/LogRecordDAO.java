package org.horbach.iba.sql_sender.dao;

import java.util.List;

import org.horbach.iba.sql_sender.entity.LogRecord;

public interface LogRecordDAO {
	
	LogRecord getLogRecord(int id);
	
	List<LogRecord> getLogRecords();
	
	void saveLogRecord(LogRecord logRecord);
	
	void updateLogRecord(LogRecord logRecord);
	
	void deleteLogRecord(LogRecord logRecord);

}
