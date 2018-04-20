package com.mxh.weibo.common.o.vo;

import com.mxh.weibo.common.Pagination;

public class FriendVo extends Pagination {

	private static final long serialVersionUID = 1L;

	private String loginId;
	
	private String uuid;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
}
