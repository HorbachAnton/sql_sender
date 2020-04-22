package org.horbach.iba.sql_sender.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.ServletContext;

import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit5.FlywayTestExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ExtendWith(FlywayTestExtension.class)
@WebAppConfiguration
@TestInstance(value = Lifecycle.PER_CLASS)
@FlywayTest
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/context/application-context/application-context.xml" })
class RegistrationControllerTest {

	public static final String REGISTRAION_CONTROLLER_BEAN_NAME = "registrationController";

	public static final String REGISTRATION_CONTROLLER_PAGE_URL = "/registration/";
	public static final String REGISTRATION_CONTROLLER_DTO_ATTRIBUTE = "userDTO";
	public static final String REGISTRATION_PAGE_VIEW_NAME = "registration";

	public static final String REGISTER_COMMAND_URL = "/register";
	public static final String REGISTER_COMMAND_USERNAME_ATTRIBUTE_NAME = "username";
	public static final String REGISTER_COMMAND_PASSWORD_ATTRIBUTE_NAME = "password";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@BeforeAll
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).apply(SecurityMockMvcConfigurers.springSecurity())
				.build();
	}

	@Test
	public void verifyConfiguration() {
		ServletContext servletContext = wac.getServletContext();

		assertThat(servletContext, is(notNullValue()));
		assertThat(servletContext, instanceOf(MockServletContext.class));
		assertThat(wac.getBean(REGISTRAION_CONTROLLER_BEAN_NAME), is(notNullValue()));
	}

	@Test
	@WithAnonymousUser
	public void testSuccessGetPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(REGISTRATION_CONTROLLER_PAGE_URL))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeExists(REGISTRATION_CONTROLLER_DTO_ATTRIBUTE))
				.andExpect(MockMvcResultMatchers.view().name(REGISTRATION_PAGE_VIEW_NAME));
	}

	@Test
	@WithAnonymousUser
	public void testFailedRegisterByExistingUsername() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(REGISTER_COMMAND_URL)
						.param(REGISTER_COMMAND_USERNAME_ATTRIBUTE_NAME, "admin")
						.param(REGISTER_COMMAND_PASSWORD_ATTRIBUTE_NAME, "admin")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeHasFieldErrorCode(REGISTRATION_CONTROLLER_DTO_ATTRIBUTE, "username",
						"errors.existing_username"))
				.andExpect(MockMvcResultMatchers.view().name(REGISTRATION_PAGE_VIEW_NAME));
	}

	@Test
	@WithAnonymousUser
	public void testFailedRegisterByEmptyUsername() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(REGISTER_COMMAND_URL)
						.param(REGISTER_COMMAND_USERNAME_ATTRIBUTE_NAME, "")
						.param(REGISTER_COMMAND_PASSWORD_ATTRIBUTE_NAME, "admin")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeHasFieldErrorCode(REGISTRATION_CONTROLLER_DTO_ATTRIBUTE, "username",
						"errors.null_username"))
				.andExpect(MockMvcResultMatchers.view().name(REGISTRATION_PAGE_VIEW_NAME));
	}

	@Test
	@WithAnonymousUser
	public void testFailedRegisterByEmptyPassword() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(REGISTER_COMMAND_URL)
						.param(REGISTER_COMMAND_USERNAME_ATTRIBUTE_NAME, "gleb")
						.param(REGISTER_COMMAND_PASSWORD_ATTRIBUTE_NAME, "")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeHasFieldErrorCode(REGISTRATION_CONTROLLER_DTO_ATTRIBUTE, "password",
						"errors.null_password"))
				.andExpect(MockMvcResultMatchers.view().name(REGISTRATION_PAGE_VIEW_NAME));
	}

	@Test
	@WithAnonymousUser
	public void testFailedRegisterByInvalidPassword() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(REGISTER_COMMAND_URL)
						.param(REGISTER_COMMAND_USERNAME_ATTRIBUTE_NAME, "gleb")
						.param(REGISTER_COMMAND_PASSWORD_ATTRIBUTE_NAME, "dddd")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeHasFieldErrorCode(REGISTRATION_CONTROLLER_DTO_ATTRIBUTE, "password",
						"errors.invalid_password"))
				.andExpect(MockMvcResultMatchers.view().name(REGISTRATION_PAGE_VIEW_NAME));
	}

	@Test
	@WithAnonymousUser
	public void testSuccessRegister() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post(REGISTER_COMMAND_URL)
						.param(REGISTER_COMMAND_USERNAME_ATTRIBUTE_NAME, "gleb")
						.param(REGISTER_COMMAND_PASSWORD_ATTRIBUTE_NAME, "dD1#5h78")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("authorization"));
	}

}
