package org.horbach.iba.sql_sender.service.impl;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.horbach.iba.sql_sender.dao.UserDAO;
import org.horbach.iba.sql_sender.entity.User;
import org.horbach.iba.sql_sender.entity.enumeration.UserRoles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private static UserDAO userDAO;
	
	@Mock
	private static PasswordEncoder passwordEncoder;

	private static User expectedUser;

	private static List<User> expectedUsers;

	private static UserServiceImpl userServiceimpl;

	@BeforeAll
	static void setUp() throws Exception {
		setUpExpectedUser();
		setUpExpectedUsers();
		setUpUserDAO();
		setUpUserServiceImpl();
	}

	private static void setUpExpectedUser() {
		expectedUser = new User(1, "Abraham", "password", true, UserRoles.ADMIN);
	}

	private static void setUpExpectedUsers() {
		expectedUsers = new ArrayList<User>(Arrays.asList(expectedUser, new User()));
	}

	private static void setUpUserDAO() {
		userDAO = mock(UserDAO.class);
		doReturn(expectedUser).when(userDAO).getUser(1);
		doReturn(expectedUsers).when(userDAO).getUsers();
	}

	private static void setUpUserServiceImpl() {
		userServiceimpl = new UserServiceImpl(userDAO, passwordEncoder);
	}

	@Test
	void testSuccessGetUser() {
		User receivedUser = userServiceimpl.getUser(1);
		assertThat(expectedUser, allOf(sameInstance(receivedUser), equalTo(receivedUser)));
	}
	
	@Test
	void testSuccessGetUsers() {
		List<User> receivedUsers = userServiceimpl.getUsers();
		assertThat(expectedUsers, allOf(sameInstance(receivedUsers), equalTo(receivedUsers)));
	}

}
