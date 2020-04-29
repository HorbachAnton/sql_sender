package org.horbach.iba.sql_sender.validator.impl;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.entity.enumeration.RequestTypes;
import org.horbach.iba.sql_sender.entity.enumeration.UserRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RequestDTOValidatorImpl implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RequestDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		validateEmptyFields(errors);
		if (!errors.hasErrors()) {
			validateRequest(target, errors);
		}
	}

	private void validateEmptyFields(Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "errors.null_request_text",
				"errors.null_request_text.message");
	}

	private void validateRequest(Object target, Errors errors) {
		RequestDTO requestDTO = (RequestDTO) target;
		String requestCommand = StringUtils.substringBefore(requestDTO.getText().trim(), " ");
		validateCorrectnessRequestText(requestCommand, errors);
		validateUserCanExecuteRequest(requestCommand, errors);
	}

	private void validateCorrectnessRequestText(String requestCommand, Errors errors) {
		if (isRequestTextIncorrectness(requestCommand)) {
			errors.rejectValue("text", "errors.invalid_request_text", "errors.invalid_request_text.message");
		}
	}

	private boolean isRequestTextIncorrectness(String requestCommand) {
		return Arrays.stream(RequestTypes.values()).noneMatch(b -> b.toString().equalsIgnoreCase(requestCommand));
	}

	private void validateUserCanExecuteRequest(String requestCommand, Errors errors) {
		if (isUserCannotExecuteRequest(requestCommand)) {
			errors.rejectValue("text", "errors.not_permission_execute_request",
					"errors.not_permission_execute_request.message");
		}
	}

	private boolean isUserCannotExecuteRequest(String requestCommand) {
		boolean isCannotExecute = false;
		if (isCannotExecute(requestCommand)) {
			isCannotExecute = true;
		}
		return isCannotExecute;
	}

	private boolean isCannotExecute(String requestCommand) {
		return getAuthority().equals(UserRoles.USER.toString())
				&& !requestCommand.equalsIgnoreCase(RequestTypes.SELECT.toString());
	}

	private String getAuthority() {
		return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).findAny().orElse(UserRoles.UNDEFINED.toString());
	}

}
