package org.horbach.iba.sql_sender.facade.impl;

import java.util.List;

import org.horbach.iba.sql_sender.facade.TableFacade;
import org.horbach.iba.sql_sender.service.TableService;

public class TableFacadeImpl implements TableFacade {

	TableService tableService;

	public TableFacadeImpl() {

	}

	public TableFacadeImpl(TableService tableService) {
		this.tableService = tableService;
	}

	@Override
	public List<String> getAvailableTableNames() {
		return tableService.getAvailableTableNames();
	}

}
