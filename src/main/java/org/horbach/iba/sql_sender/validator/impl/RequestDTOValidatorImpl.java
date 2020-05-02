package org.horbach.iba.sql_sender.validator.impl;

import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.horbach.iba.sql_sender.dto.RequestDTO;
import org.horbach.iba.sql_sender.entity.enumeration.RequestTypes;
import org.horbach.iba.sql_sender.entity.enumeration.SystemTables;
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
		String requestText = requestDTO.getText().trim();
		String requestCommand = StringUtils.substringBefore(requestText, " ");
		validateCorrectnessRequestText(requestCommand, errors);
		if (!errors.hasErrors()) {
			validateUserCanExecuteRequest(requestText, requestCommand, errors);
		}
	}

	private void validateCorrectnessRequestText(String requestCommand, Errors errors) {
		if (isRequestTextIncorrectness(requestCommand)) {
			errors.rejectValue("text", "errors.invalid_request_text", "errors.invalid_request_text.message");
		}
	}

	private boolean isRequestTextIncorrectness(String requestCommand) {
		return Arrays.stream(RequestTypes.values()).noneMatch(b -> b.toString().equalsIgnoreCase(requestCommand));
	}

	private void validateUserCanExecuteRequest(String requestText, String requestCommand, Errors errors) {
		if (isUserCannotExecuteRequest(requestText, requestCommand)) {
			errors.rejectValue("text", "errors.not_permission_execute_request",
					"errors.not_permission_execute_request.message");
		}
	}

	private boolean isUserCannotExecuteRequest(String requestText, String requestCommand) {
		boolean isCannotExecute = false;
		if (isCannotExecute(requestText, requestCommand)) {
			isCannotExecute = true;
		}
		return isCannotExecute;
	}

	private boolean isCannotExecute(String requestText, String requestCommand) {
		return getAuthority().equalsIgnoreCase(UserRoles.USER.toString())
				&& (!requestCommand.equalsIgnoreCase(RequestTypes.SELECT.toString())
						|| isContainsSystemTables(requestText));
	}

	private String getAuthority() {
		return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).findAny().orElse(UserRoles.UNDEFINED.toString());
	}

	private boolean isContainsSystemTables(String request) {
		return Stream.of(request.split(" "))
				.anyMatch(a -> a.equalsIgnoreCase(SystemTables.FLYWAY_SCHEMA_HISTORY.toString())
						|| a.equalsIgnoreCase(SystemTables.LOG_RECORD.toString()));
	}

}
