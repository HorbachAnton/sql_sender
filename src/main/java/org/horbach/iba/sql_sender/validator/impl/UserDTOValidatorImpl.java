package org.horbach.iba.sql_sender.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.horbach.iba.sql_sender.dto.UserDTO;
import org.horbach.iba.sql_sender.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserDTOValidatorImpl implements Validator {

	private static final String USERNAME_FIELD_NAME = "username";
	private static final String NULL_USERNAME_ERROR_CODE = "errors.null_username";
	private static final String NULL_USERNAME_DEFAULT_MESSAGE = "errors.null_username.message";
	private static final String EXISTING_USERNAME_ERROR_CODE = "errors.existing_username";
	private static final String EXISTING_USERNAME_DEFAULT_MESSAGE = "errors.existing_username.message";

	private static final String PASSWORD_FIELD_NAME = "password";
	private static final String NULL_PASSWORD_ERROR_CODE = "errors.null_password";
	private static final String NULL_PASSWORD_DEFAULT_MESSAGE = "errors.null_password.message";
	private static final String INVALID_PASSWORD_ERROR_CODE = "errors.invalid_password";
	private static final String INVALID_PASSWORD_DEFAULT_MESSAGE = "errors.invalid_password.message";

	private static final String PASSWORD_REGEX = "^(?=\\P{Ll}*\\p{Ll})(?=\\P{Lu}*\\p{Lu})(?=\\P{N}*\\p{N})(?=[\\p{L}\\p{N}]*[^\\p{L}\\p{N}])[\\s\\S]{8,}$";
	private static final Pattern PATTERN_PASSWORD = Pattern.compile(PASSWORD_REGEX);

	private UserService userService;

	public UserDTOValidatorImpl() {

	}

	public UserDTOValidatorImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		validateEmptyFields(errors);
		if (!errors.hasErrors()) {
			validateUserDTO(target, errors);
		}
	}

	private void validateEmptyFields(Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, USERNAME_FIELD_NAME, NULL_USERNAME_ERROR_CODE,
				NULL_USERNAME_DEFAULT_MESSAGE);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD_FIELD_NAME, NULL_PASSWORD_ERROR_CODE,
				NULL_PASSWORD_DEFAULT_MESSAGE);
	}

	private void validateUserDTO(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;
		validatePassword(userDTO.getPassword(), errors);
		validateUserExists(userDTO.getUsername(), errors);
	}

	private void validatePassword(String password, Errors errors) {
		Matcher matcher = PATTERN_PASSWORD.matcher(password);
		if (!matcher.matches()) {
			errors.rejectValue(PASSWORD_FIELD_NAME, INVALID_PASSWORD_ERROR_CODE, INVALID_PASSWORD_DEFAULT_MESSAGE);
		}
	}

	private void validateUserExists(String username, Errors errors) {
		if (userService.getUser(username) != null) {
			errors.rejectValue(USERNAME_FIELD_NAME, EXISTING_USERNAME_ERROR_CODE, EXISTING_USERNAME_DEFAULT_MESSAGE);
		}
	}

}
