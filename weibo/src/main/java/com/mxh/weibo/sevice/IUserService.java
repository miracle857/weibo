package com.mxh.weibo.sevice;

import com.mxh.weibo.common.model.User;

public interface IUserService {
	
	/**
	 * 注册
	 * 
	 * @param user
	 */
	void register(User user);
	
	/**
	 * 登录操作
	 * 
	 * @param user
	 */
	void login(User user);
	
	/**
	 * 找回密码操作
	 * 
	 * @param user
	 * @throws Exception 
	 */
	void findPassword(User user) throws Exception;
}
