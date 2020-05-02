package org.horbach.iba.sql_sender.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.horbach.iba.sql_sender.dao.TableDAO;
import org.horbach.iba.sql_sender.entity.enumeration.SystemTables;
import org.horbach.iba.sql_sender.service.TableService;

@Transactional
public class TableServiceImpl implements TableService {

	TableDAO tableDAO;

	public TableServiceImpl() {

	}

	public TableServiceImpl(TableDAO tableDAO) {
		this.tableDAO = tableDAO;
	}

	@Override
	public List<String> getAvailableTableNames() {
		List<String> tableNames = tableDAO.getTableNames();
		return tableNames.stream().filter(tableName -> !isSystemTable(tableName)).collect(Collectors.toList());
	}

	private boolean isSystemTable(String tableName) {
		return Stream.of(SystemTables.values())
				.anyMatch(systemTable -> systemTable.toString().equalsIgnoreCase(tableName));
	}

}
