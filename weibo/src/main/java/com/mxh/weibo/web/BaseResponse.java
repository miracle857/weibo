package com.mxh.weibo.web;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

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

	public BaseResponse() {
		super();
		success = false;
	}

	public BaseResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public BaseResponse(boolean success, String message, T body) {
		super();
		this.success = success;
		this.message = message;
		this.body = body;
	}

	public boolean isSuccess() {
		return success;
	}

	public BaseResponse<T> setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public BaseResponse<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getBody() {
		return body;
	}

	public BaseResponse<T> setBody(T body) {
		this.body = body;
		return this;
	}

}
