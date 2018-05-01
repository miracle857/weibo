package com.mxh.weibo.sevice;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.exception.WeiboException;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.o.UserCriterua;
import com.mxh.weibo.common.o.UserToken;
import com.mxh.weibo.common.o.vo.UserVo;

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

	/**
	 * 获取粉丝列表
	 * 
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	PaginatedList<UserVo> getFans(String login,UserCriterua criterua) throws Exception;

	PaginatedList<UserVo> getFollower(String login,UserCriterua criterua) throws Exception;

	/**
	 * 关注 or 取消关注
	 * 
	 * @param follower
	 * @param followered
	 * @param f
	 *            true：关注操作。 false：取消关注操作
	 * @throws Exception
	 */
	void unFollow(String follower, String followered) throws Exception;

	void follow(String follower, String followered) throws Exception;
	
	PaginatedList<User> userList(UserCriterua criterua);

	UserVo getUserById(String id,String loginId);
}
