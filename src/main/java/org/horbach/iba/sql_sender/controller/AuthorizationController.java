package org.horbach.iba.sql_sender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

	private static final String GET_AUTHORIZATION_PAGE_REQUEST = "/authorization/";
	private static final String AUTHORIZATION_PAGE_NAME = "authorization";

	@GetMapping(value = GET_AUTHORIZATION_PAGE_REQUEST)
	public String getAuthorizationPage() {
		return AUTHORIZATION_PAGE_NAME;
	}

}
