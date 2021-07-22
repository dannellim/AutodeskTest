package com.beta.replyservice;

import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beta.replyservice.utils.*;

@RestController
public class ReplyController {

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}

	@GetMapping("/v2/reply/{message}")
	public ReplyMessage replyingV2(@PathVariable String message) {
		String result = "";
		try {
			String[] rulesAndData = message.split("-");
			if (rulesAndData.length == 2) {
				String rules = rulesAndData[0];
				String data = rulesAndData[1];
				if (rules.length() >= 2) {
					try {
						result = Util.processV2Reply(rules, data);
					} catch (NoSuchAlgorithmException nsa) {
						result = ErrorMsg.NO_MD5;
					}
				} else {
					result = ErrorMsg.INVALID_RULES;
				}
			} else if (rulesAndData.length == 1) {
				result = message;
			} else {
				result = ErrorMsg.INVALID_ARGUMENT;
			}
		} catch (Exception e) {
			result = ErrorMsg.GENERIC_EXCEPTION + "\n" + e.getMessage();
		}
		return new ReplyMessage(result);
	}

}