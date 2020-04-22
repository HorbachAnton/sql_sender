package org.horbach.iba.sql_sender.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@TestInstance(value = Lifecycle.PER_CLASS)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/context/application-context/application-context.xml" })
class AuthenticationControllerTest {

	public static final String WELCOME_CONTROLLER_BEAN_NAME = "welcomeController";

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
		assertThat(wac.getBean(WELCOME_CONTROLLER_BEAN_NAME), is(notNullValue()));
	}

	@Test
	@WithUserDetails(userDetailsServiceBeanName = "userDetailsService", value = "admin")
	public void testSuccessAuthentication() throws Exception {
		mockMvc.perform(get("/welcome/")).andExpect(status().isOk());
	}

}
