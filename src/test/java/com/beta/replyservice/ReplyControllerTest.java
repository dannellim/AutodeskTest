package com.beta.replyservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
class ReplyControllerTest extends RestServiceApplicationTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testReply() throws Exception {
		mockMvc.perform(get("/reply"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.message").value("Message is empty"));
	}
	
	@Test
	public void testReplyWithMessage() throws Exception {
		mockMvc.perform(get("/reply/kbzw9ru"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.message").value("kbzw9ru"));
	}
	
	@Test
	public void testOneReplyWithMessageV2() throws Exception {
		mockMvc.perform(get("/v2/reply/11-kbzw9ru"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.message").value("kbzw9ru"));
	}
	
	@Test
	public void testTwoReplyWithMessageV2() throws Exception {
		mockMvc.perform(get("/v2/reply/12-kbzw9ru"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.message").value("5a8973b3b1fafaeaadf10e195c6e1dd4"));
	}
	
	@Test
	public void testThreeReplyWithMessageV2() throws Exception {
		mockMvc.perform(get("/v2/reply/22-kbzw9ru"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.message").value("e8501e64cf0a9fa45e3c25aa9e77ffd5"));
	}
}
