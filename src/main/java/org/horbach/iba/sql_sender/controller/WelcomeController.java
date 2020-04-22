package org.horbach.iba.sql_sender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	private static final String GET_WELCOME_PAGE_REQUEST = "/welcome/";
	private static final String WELCOME_PAGE_NAME = "welcome";
	
	@GetMapping(value = GET_WELCOME_PAGE_REQUEST)
	public String getWelcomePage() {
		return WELCOME_PAGE_NAME;
	}

}
