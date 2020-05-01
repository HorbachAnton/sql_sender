package org.horbach.iba.sql_sender.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithUserDetails;
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
@WebAppConfiguration
@TestInstance(value = Lifecycle.PER_CLASS)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/context/application-context/application-context.xml" })
class QueryHistoryControllerTest {

	private static final String GET_QUERY_HISTORY_PAGE_REQUEST = "/query_history/";

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
		assertThat(wac.getBean("queryHistoryController"), is(notNullValue()));
	}

	@Test
	@WithUserDetails(userDetailsServiceBeanName = "userDetailsService", value = "admin")
	public void testSuccessGetPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(GET_QUERY_HISTORY_PAGE_REQUEST))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("query_history"));
	}

	@Test
	@WithAnonymousUser
	public void testFailedGetPageByAnonymousUser() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(GET_QUERY_HISTORY_PAGE_REQUEST))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is(302))
				.andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/authorization/"));
	}

}
