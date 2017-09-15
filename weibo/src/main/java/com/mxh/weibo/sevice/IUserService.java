package com.mxh.weibo.sevice;

import com.mxh.weibo.common.exception.WeiboException;
import com.mxh.weibo.common.model.User;

public interface IUserService {
	
	/**
	 * 注册
	 * 
	 * @param user
	 * @throws Exception 
	 */
	void register(User user) throws Exception;
	
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
	
	/**
	 * 检查用户名是否存在
	 * 
	 * @param username
	 * @throws WeiboException
	 */
	void chickUserNameExist(String username) throws WeiboException;
	
	/**
	 * 检查邮箱是否被注册
	 * 
	 * @param username
	 * @throws WeiboException
	 */
	void chickEmailExist(String email) throws WeiboException;
}
