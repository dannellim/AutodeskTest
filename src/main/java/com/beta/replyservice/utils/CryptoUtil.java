package com.beta.replyservice.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtil {

	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	
    public static String md5Hash(String input) throws NoSuchAlgorithmException {
    	byte[] md5InBytes = digest(input.getBytes(UTF_8));
    	return bytesToHex(md5InBytes);
    }
	
	private static byte[] digest(byte[] input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] result = md.digest(input);
        return result;
    }
	
	private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
