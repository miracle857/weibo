package com.mxh.weibo.sevice.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.DC;
import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.email.Mail;
import com.mxh.weibo.common.exception.WeiboException;
import com.mxh.weibo.common.model.FollowFollower;
import com.mxh.weibo.common.model.FollowFollowerExample;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.o.UserCriterua;
import com.mxh.weibo.common.o.UserToken;
import com.mxh.weibo.common.o.vo.UserVo;
import com.mxh.weibo.common.util.CollectionUtil;
import com.mxh.weibo.common.util.MD5;
import com.mxh.weibo.dao.FollowFollowerMapper;
import com.mxh.weibo.dao.UserMapper;
import com.mxh.weibo.sevice.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private FollowFollowerMapper followFollowerMapper;

	public void register(UserToken userToken) throws Exception {

		// 检查用户名和邮箱
		this.chickUserNameExist(userToken.getUsername());
		this.chickEmailExist(userToken.getEmail());
		
		// 判定密码相同与否
		if(!(userToken.getPassword().equals(userToken.getRpassword()))){
			throw new WeiboException("两次密码不一致");
		}
		
		// 整理数据，插入数据库
		User user = new User();
		PropertyUtils.copyProperties(user, userToken);
		user.setWeibo(0);
		user.setFollow(0);
		user.setFollower(0);
		user.setDeleted((byte) 0);
		user.setStatus(DC.STATUS_NORMAL);
		user.setPassword(MD5.getMD5(user.getPassword()));
		userMapper.insertSelective(user);
	}

	public User login(String username,String password) throws WeiboException {
		if(StringUtils.isBlank(username)){
			throw new WeiboException("用户名不能为空");
		}
		User user = userMapper.selectByEmailOrUsername(null, username);
		if(user == null || !(user.getPassword().equals(MD5.getMD5(password)))){
			throw new WeiboException("用户名或者密码错误");
		}
		return user;
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
		if(StringUtils.isBlank(username)){
			throw new WeiboException("用户名不能为空");
		}
		User user = userMapper.selectByEmailOrUsername(null, username);
		if (user != null) {
			throw new WeiboException("用户名存在");
		}
	}

	public void chickEmailExist(String email) throws WeiboException {
		if(StringUtils.isBlank(email)){
			throw new WeiboException("邮箱不能为空");
		}
		User user = userMapper.selectByEmailOrUsername(email, null);
		if (user != null) {
			throw new WeiboException("该邮箱已经被注册");
		}
	}

	@Override
	public User changeUserInfo(User user) throws WeiboException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User changeUserPassword(UserToken userToken) throws WeiboException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserVo> getFans(String uuid) throws Exception {
		// 获取粉丝ids列表
		FollowFollowerExample example = new FollowFollowerExample();
		example.createCriteria().andFollowedEqualTo(uuid);
		List<FollowFollower> list = followFollowerMapper.selectByExample(example);

		// 获取粉丝详细信息
		List<User> users = userMapper.selectByUuids(CollectionUtil.FiledToList(list, "followed", String.class));

		// 封装信息
		List<UserVo> resu = new ArrayList<>();
		for (User user : users) {
			UserVo vo = new UserVo();
			PropertyUtils.copyProperties(vo, user);

			// 我是否关注我的粉丝
			FollowFollowerExample example2 = new FollowFollowerExample();
			example.createCriteria().andFollowedEqualTo(user.getUuid()).andFollowEqualTo(uuid);
			List<FollowFollower> list2 = followFollowerMapper.selectByExample(example2);
			if (CollectionUtils.isNotEmpty(list2)) {
				vo.setMutual((byte) 1);
			}

			resu.add(vo);
		}

		return resu;
	}

	@Override
	public List<UserVo> getFollower(String uuid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unFollow(String follower, String followered) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void follow(String follower, String followered) throws Exception {
		FollowFollowerExample example = new FollowFollowerExample();
		example.createCriteria().andFollowEqualTo(follower).andFollowedEqualTo(followered);
		List<FollowFollower> select1 = followFollowerMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(select1)) {
			throw new Exception("不能重复关注。");
		}

		FollowFollower record = new FollowFollower();
		record.setFollow(follower);
		record.setFollowed(followered);
		followFollowerMapper.insertSelective(record);
	}

	@Override
	public PaginatedList<User> userList(UserCriterua criterua) {
		// TODO Auto-generated method stub
		return null;
	}

}
