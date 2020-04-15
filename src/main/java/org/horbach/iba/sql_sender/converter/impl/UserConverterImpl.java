package org.horbach.iba.sql_sender.converter.impl;

import org.horbach.iba.sql_sender.converter.UserConverter;
import org.horbach.iba.sql_sender.dto.UserDTO;
import org.horbach.iba.sql_sender.entity.User;

public class UserConverterImpl implements UserConverter {

	@Override
	public UserDTO convertUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setEnabled(user.isEnabled());
		userDTO.setUserRole(user.getUserRole());
		return userDTO;
	}

	@Override
	public User convertUserDTOToUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setEnabled(userDTO.isEnabled());
		user.setUserRole(userDTO.getUserRole());
		return user;
	}

}
