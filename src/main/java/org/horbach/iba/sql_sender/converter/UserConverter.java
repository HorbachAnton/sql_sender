package org.horbach.iba.sql_sender.converter;

import org.horbach.iba.sql_sender.dto.UserDTO;
import org.horbach.iba.sql_sender.entity.User;

public interface UserConverter {

	UserDTO convertUserToUserDTO(User user);

	User convertUserDTOToUser(UserDTO userDTO);

}
