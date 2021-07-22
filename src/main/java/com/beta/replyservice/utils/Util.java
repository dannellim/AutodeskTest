package com.beta.replyservice.utils;

import java.security.NoSuchAlgorithmException;

public class Util {
	
	public static String processV2Reply(String rules, String data) throws NoSuchAlgorithmException {
		String output = data;
		for (char rule : rules.toCharArray()) {
			switch (String.valueOf(rule)) {
			case Rules.REVERSE:
				output = Util.reverse(output);
				break;
			case Rules.MD5HASH:
				output = CryptoUtil.md5Hash(output);
				break;
			}
		}
		return output;
	}

	public static String reverse(String input) {
		StringBuilder sb = new StringBuilder(input);
		sb.reverse();
		return sb.toString();
	}
}
