package org.horbach.iba.sql_sender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	private static final String GET_WELCOME_PAGE_REQUEST = "/";
	private static final String WELCOME_PAGE_NAME = "index";
	
	@GetMapping(value = GET_WELCOME_PAGE_REQUEST)
	public String getAuthorizationPage() {
		return WELCOME_PAGE_NAME;
	}

}
