package com.mxh.weibo.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.DC;
import com.mxh.weibo.common.email.Mail;
import com.mxh.weibo.common.exception.WeiboException;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.util.MD5;
import com.mxh.weibo.dao.UserMapper;
import com.mxh.weibo.sevice.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	public UserMapper userMapper;

	public void register(User user) throws Exception {

		chickUserNameExist(user.getUsername());

		user.setDeleted((byte) 0);
		user.setStatus(DC.STATUS_NORMAL);
		user.setPassword(MD5.getMD5(user.getPassword()));
		userMapper.insertSelective(user);
	}

	public void login(User user) {
		// TODO Auto-generated method stub

	}

	public void findPassword(User user) throws Exception {
		User selectByEmailOrUsername = userMapper.selectByEmailOrUsername(user.getEmail(), user.getUsername());
		if (selectByEmailOrUsername != null) {
			String pwd = Mail.send(user.getEmail(), user.getUsername());
			user.setPassword(MD5.getMD5(pwd));
			userMapper.updateByUserName(user);
		} else {
			throw new WeiboException("账号或邮箱错误");
		}

	}

	public void chickUserNameExist(String username) throws WeiboException {
		User user = userMapper.selectByEmailOrUsername(null, username);
		if (user == null) {
			throw new WeiboException("用户名存在");
		}
	}

	public void chickEmailExist(String email) throws WeiboException {
		// TODO Auto-generated method stub
		
	}
}
