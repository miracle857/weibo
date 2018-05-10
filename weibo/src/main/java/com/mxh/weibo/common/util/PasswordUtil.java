package com.mxh.weibo.common.util;

import java.util.Random;

public class PasswordUtil {

	private PasswordUtil() {
		// TODO Auto-generated constructor stub
	}
	
	private static String string = "abcdefghijklmnopqrstuvwxyz123456789QAZWSXEDCRFVTGBYHNUJMIKLOP";

	public static String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		int len = string.length();
		for (int i = 0; i < length; i++) {
			sb.append(string.charAt(new Random().nextInt(len)));
		}
		return sb.toString();
	}

}
