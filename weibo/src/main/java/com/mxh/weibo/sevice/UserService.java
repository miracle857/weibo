package com.mxh.weibo.sevice;

import com.mxh.weibo.common.dto.UserToken;
import com.mxh.weibo.common.exception.WeiboException;
import com.mxh.weibo.common.model.User;

public interface UserService {

	/**
	 * 注册
	 * 
	 * @param user
	 * @throws Exception
	 */
	void register(UserToken user) throws Exception;

	/**
	 * 登录操作
	 * 
	 * @param user
	 * @return
	 * @throws WeiboException
	 */
	User login(String username,String password) throws WeiboException;

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

	/**
	 * 修改个人信息
	 * 
	 * @param user
	 * @return
	 * @throws WeiboException
	 */
	User changeUserInfo(User user) throws WeiboException;

	/**
	 * 修改密码
	 * 
	 * @param userToken
	 * @return
	 * @throws WeiboException
	 */
	User changeUserPassword(UserToken userToken) throws WeiboException;
}
