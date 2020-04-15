package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.LogRecordDAO;
import org.horbach.iba.sql_sender.entity.LogRecord;
import org.horbach.iba.sql_sender.entity.Ticket;

public class LogRecordDAOImpl extends AbstractBasicDAOImpl implements LogRecordDAO {

	private static final String GET_LOG_RECORD_QUERY = "SELECT * FROM log_record";
	
	public LogRecordDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public LogRecord getLogRecord(int id) {
		return (LogRecord) getById(LogRecord.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogRecord> getLogRecords() {
		return getCurrentSession().createSQLQuery(GET_LOG_RECORD_QUERY).addEntity(Ticket.class).list();
	}

	@Override
	public void saveLogRecord(LogRecord logRecord) {
		save(logRecord);
	}

	@Override
	public void updateLogRecord(LogRecord logRecord) {
		update(logRecord);
	}

	@Override
	public void deleteLogRecord(LogRecord logRecord) {
		delete(logRecord);
	}

}
