package com.mxh.weibo.common.util;

import java.util.UUID;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2014  
 * Company:		上海天地汇
 * Author:		yanhui.rao
 * Version:		1.0  
 * Created at:	2016年11月22日 上午21:00:32  
 * </pre>
 */
public class UUIDUtils {

	public static String getUUID() {
		String returnValue = UUID.randomUUID().toString();
		return returnValue.replaceAll("-", "");
	}

}
