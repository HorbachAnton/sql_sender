package org.horbach.iba.sql_sender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QueryHistoryController {

	@GetMapping(value = "/query_history/")
	public String getPage() {
		return "query_history";
	}

}
