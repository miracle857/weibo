package com.mxh.weibo.common.exception;

public class WeiboException extends Exception{

	private static final long serialVersionUID = 1L;
	
    public WeiboException(String message) {
        super(message);
    }

    public WeiboException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeiboException(Throwable cause) {
        super(cause);
    }
}
