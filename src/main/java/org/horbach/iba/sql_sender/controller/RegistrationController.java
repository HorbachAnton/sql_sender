package org.horbach.iba.sql_sender.controller;

import org.horbach.iba.sql_sender.dto.UserDTO;
import org.horbach.iba.sql_sender.facade.RegistrationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

	private static final String GET_REGISTRATION_PAGE_REQUEST = "/registration/";
	private static final String REGISTER_REQUEST = "/register";

	private static final String USER_DTO_MODEL_ATTRIBUTE_NAME = "userDTO";
	private static final String AUTHORIZATION_PAGE_NAME = "authorization";

	private static final String REGISTRATION_PAGE_NAME = "registration";

	@Autowired
	private RegistrationFacade registrationFacade;

	@Autowired
	private Validator userDTOValidator;

	@GetMapping(value = GET_REGISTRATION_PAGE_REQUEST)
	public String getPage(Model model) {
		model.addAttribute(USER_DTO_MODEL_ATTRIBUTE_NAME, new UserDTO());
		return REGISTRATION_PAGE_NAME;
	}

	@PostMapping(value = REGISTER_REQUEST)
	public String register(@ModelAttribute(USER_DTO_MODEL_ATTRIBUTE_NAME) UserDTO userDTO, BindingResult result) {
		userDTOValidator.validate(userDTO, result);

		if (result.hasErrors()) {
			return REGISTRATION_PAGE_NAME;
		}

		registrationFacade.register(userDTO);
		return AUTHORIZATION_PAGE_NAME;
	}

}
