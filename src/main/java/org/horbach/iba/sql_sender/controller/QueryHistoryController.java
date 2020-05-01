package org.horbach.iba.sql_sender.controller;

import org.horbach.iba.sql_sender.facade.QueriesHistoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QueryHistoryController {

	@Autowired
	QueriesHistoryFacade queriesHistoryFacade;

	@GetMapping(value = "/query_history/")
	public String getPage(Model model) {
		model.addAttribute("user_requests", queriesHistoryFacade.getUserRequests());
		return "query_history";
	}

}
