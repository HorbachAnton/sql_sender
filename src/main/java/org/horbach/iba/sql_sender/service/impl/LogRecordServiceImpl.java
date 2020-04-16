package org.horbach.iba.sql_sender.service.impl;

import java.util.List;

import org.horbach.iba.sql_sender.dao.LogRecordDAO;
import org.horbach.iba.sql_sender.entity.LogRecord;
import org.horbach.iba.sql_sender.service.LogRecordService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class LogRecordServiceImpl implements LogRecordService {

	LogRecordDAO logRecordDAO;

	public LogRecordServiceImpl() {

	}

	public LogRecordServiceImpl(LogRecordDAO logRecordDAO) {
		this.logRecordDAO = logRecordDAO;
	}

	@Override
	public LogRecord getLogRecord(int id) {
		return logRecordDAO.getLogRecord(id);
	}

	@Override
	public List<LogRecord> getLogRecords() {
		return logRecordDAO.getLogRecords();
	}

	@Override
	public void saveLogRecord(LogRecord logRecord) {
		logRecordDAO.saveLogRecord(logRecord);
	}

	@Override
	public void updateLogRecord(LogRecord logRecord) {
		logRecordDAO.updateLogRecord(logRecord);
	}

	@Override
	public void deleteLogRecord(LogRecord logRecord) {
		logRecordDAO.deleteLogRecord(logRecord);
	}

}
