package org.horbach.iba.sql_sender.converter.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.horbach.iba.sql_sender.converter.UserConverter;
import org.horbach.iba.sql_sender.dto.UserDTO;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.entity.enumeration.UserRoles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/context/converter-context/converter-context.xml" })
class UserConverterImplTest {

	@Autowired
	private UserConverter userConverter;

	private static UserDTO userDTO;

	private static User user;

	@BeforeAll
	static void setUp() throws Exception {
		setUpUserDTO();
		setUpUser();
	}

	static void setUpUserDTO() {
		userDTO = new UserDTO(1, "Abraham", "password", true, UserRoles.ADMIN);
	}

	static void setUpUser() {
		user = new User(1, "Abraham", "password", true, UserRoles.ADMIN);
	}

	@Test
	void testSuccessConvertUserToUserDTO() {
		assertThat(userDTO, equalTo(userConverter.convertUserToUserDTO(user)));
	}

	@Test
	void testSuccessConvertDTOUserToUser() {
		assertThat(user, equalTo(userConverter.convertUserDTOToUser(userDTO)));
	}

}
