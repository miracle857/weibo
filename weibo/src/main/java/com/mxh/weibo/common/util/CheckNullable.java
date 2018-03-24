package com.mxh.weibo.common.util;

import org.apache.commons.lang.StringUtils;

public class CheckNullable {

	public static void checkNull(Object s, String errorMsg) throws Exception {

		if ((s instanceof String && StringUtils.isNotBlank((String) s)) || (s instanceof Object && s != null)) {
			return;
		}
		throw new Exception(errorMsg);
	}
}
