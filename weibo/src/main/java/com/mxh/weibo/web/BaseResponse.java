package com.mxh.weibo.web;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 返回是否成功
	 */
	private boolean success;

	/**
	 * 返回消息
	 */
	private String message;

	/**
	 * 返回内容
	 */
	private T body;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
	
	
}
