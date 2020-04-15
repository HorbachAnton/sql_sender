package org.horbach.iba.sql_sender.facade.impl;

import org.horbach.iba.sql_sender.converter.UserConverter;
import org.horbach.iba.sql_sender.dto.UserDTO;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.facade.RegistrationFacade;
import org.horbach.iba.sql_sender.service.UserService;

public class RegistrationFacadeImpl implements RegistrationFacade {

	private UserConverter userConverter;
	private UserService userService;

	public RegistrationFacadeImpl() {

	}

	public RegistrationFacadeImpl(UserConverter userConverter, UserService userService) {
		this.userConverter = userConverter;
		this.userService = userService;
	}

	@Override
	public void register(UserDTO userDTO) {
		User user = userConverter.convertUserDTOToUser(userDTO);
		userService.registerUser(user);
	}

}
