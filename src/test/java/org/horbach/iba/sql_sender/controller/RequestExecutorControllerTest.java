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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
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
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/context/application-context/application-context.xml" })
class RequestExecutorControllerTest {

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
		assertThat(wac.getBean("requestExecutorController"), is(notNullValue()));
	}

	@Test
	@WithMockUser
	public void testSuccessGetPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/request-executor/")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("request-executor"));
	}

	@Test
	@WithMockUser
	public void testFailedExecuteRequestByNullRequestText() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/execute-request").param("text", "")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeHasFieldErrorCode("requestDTO", "text", "errors.null_request_text"));
	}

	@Test
	@WithMockUser
	public void testFailedExecuteRequestByInvalidRequestText() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/execute-request").param("text", "erergeg")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().attributeHasFieldErrorCode("requestDTO", "text", "errors.invalid_request_text"));
	}

	@Test
	@WithMockUser(authorities = "USER")
	public void testFailedExecuteRequestByNotPermisson() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/execute-request").param("text", "UPDATE sfe")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(model()
						.attributeHasFieldErrorCode("requestDTO", "text", "errors.not_permission_execute_request"));
	}

	@Test
	@FlywayTest
	@WithUserDetails(userDetailsServiceBeanName = "userDetailsService", value = "admin")
	public void testSuccesExecuteSelectRequest() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/execute-request").param("text", "SELECT * FROM EVENT")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().hasNoErrors());
	}

	@Test
	@FlywayTest(locationsForMigrate = "filesystem:src/test/resources/migrations-test")
	@WithUserDetails(userDetailsServiceBeanName = "userDetailsService", value = "admin")
	public void testSuccesExecuteUpdateRequest() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/execute-request")
						.param("text", "UPDATE event SET title='test-event' WHERE title='test-event'")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().hasNoErrors());
	}

	@Test
	@FlywayTest(locationsForMigrate = "filesystem:src/test/resources/migrations-test")
	@WithUserDetails(userDetailsServiceBeanName = "userDetailsService", value = "admin")
	public void testSuccesExecuteInsertRequest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/execute-request").param("text",
				"INSERT INTO EVENT(title, summary, date, Location_id, price) VALUES('test-event-2', 'test-event-2', '2021-11-20 20:12:40', '1', '12')")
				.with(SecurityMockMvcRequestPostProcessors.csrf())).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(model().hasNoErrors());
	}

	@Test
	@FlywayTest(locationsForMigrate = "filesystem:src/test/resources/migrations-test")
	@WithUserDetails(userDetailsServiceBeanName = "userDetailsService", value = "admin")
	public void testSuccesExecuteDeleteRequest() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/execute-request")
						.param("text", "DELETE FROM EVENT WHERE title='test-event'")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().hasNoErrors());
	}

	@Test
	@FlywayTest(locationsForMigrate = "filesystem:src/test/resources/migrations-test")
	@WithUserDetails(userDetailsServiceBeanName = "userDetailsService", value = "admin")
	public void testSuccesExecuteCreateTableRequest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/execute-request").param("text",
				"CREATE table test_table (test_table_id INT NOT NULL AUTO_INCREMENT, PRIMARY KEY ( test_table_id ))")
				.with(SecurityMockMvcRequestPostProcessors.csrf())).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(model().hasNoErrors());
	}

	@Test
	@FlywayTest(locationsForMigrate = "filesystem:src/test/resources/migrations-test")
	@WithUserDetails(userDetailsServiceBeanName = "userDetailsService", value = "admin")
	public void testSuccesExecuteDropTableRequest() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/execute-request").param("text", "DROP TABLE test_table_2")
						.with(SecurityMockMvcRequestPostProcessors.csrf()))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(model().hasNoErrors());
	}

}
