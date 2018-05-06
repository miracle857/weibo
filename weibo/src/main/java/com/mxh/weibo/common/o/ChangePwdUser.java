package com.mxh.weibo.common.o;

import java.io.Serializable;

public class ChangePwdUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	private String oldPassword;
	
	private String newPassword;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	

}
