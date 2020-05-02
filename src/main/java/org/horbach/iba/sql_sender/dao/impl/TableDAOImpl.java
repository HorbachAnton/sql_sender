package org.horbach.iba.sql_sender.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.horbach.iba.sql_sender.dao.TableDAO;

public class TableDAOImpl extends AbstractBasicDAOImpl implements TableDAO {

	private static final String GET_TABLE_NAMES_QUERY = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'sql_sender';";

	public TableDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTableNames() {
		return getCurrentSession().createSQLQuery(GET_TABLE_NAMES_QUERY).getResultList();
	}

}
