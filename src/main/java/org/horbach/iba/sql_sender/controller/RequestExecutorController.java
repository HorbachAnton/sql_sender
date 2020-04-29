package org.horbach.iba.sql_sender.controller;

import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.facade.RequestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RequestExecutorController {

	@Autowired
	private Validator requestDTOValidator;

	@Autowired
	private RequestFacade requestFacade;

	@ModelAttribute("requestDTO")
	public RequestDTO getRequestDTO() {
		return new RequestDTO();
	}

	@GetMapping(value = "/request-executor/")
	public String getRequestExecutorPage() {
		return "request-executor";
	}

	@PostMapping(value = "/execute-request")
	public String executeRequest(@ModelAttribute("requestDTO") RequestDTO requestDTO, BindingResult result) {
		requestDTOValidator.validate(requestDTO, result);
		if (result.hasErrors()) {
			return "request-executor";
		}
		requestFacade.executeRequest(requestDTO);
		return "request-executor";
	}

}
