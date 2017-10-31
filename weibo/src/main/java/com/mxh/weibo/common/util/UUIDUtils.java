package com.mxh.weibo.common.util;

import java.util.UUID;

/**
 * 生成全局唯一UUID
 */
public class UUIDUtils {

	private UUIDUtils() {}
	
	public static String getUUID() {
		String returnValue = UUID.randomUUID().toString();
		return returnValue.replaceAll("-", "");
	}

}
