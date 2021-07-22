package com.beta.replyservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReplyMessageTest {


	ReplyMessage replyMessage = new ReplyMessage("Test");
	
	@Test
	void testEquals() {
		String message = replyMessage.getMessage();
		assertEquals(message, "Test");
	}
	
	@Test
	void testNotEquals() {
		String message = replyMessage.getMessage();
		assertNotEquals(message, "Test1");
	}

}
