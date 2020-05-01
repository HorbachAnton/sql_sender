package org.horbach.iba.sql_sender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {
	
	@GetMapping(value="/403/")
	public String getPage() {
		return "forbidden";
	}

}
