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
import com.mxh.weibo.common.model.UserExample;
import com.mxh.weibo.common.o.ChangePwdUser;
import com.mxh.weibo.common.o.UserCriterua;
import com.mxh.weibo.common.o.UserToken;
import com.mxh.weibo.common.o.vo.UserVo;
import com.mxh.weibo.common.util.AccountValidatorUtil;
import com.mxh.weibo.common.util.CollectionUtil;
import com.mxh.weibo.common.util.MD5;
import com.mxh.weibo.common.util.PasswordUtil;
import com.mxh.weibo.common.util.UUIDUtils;
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
		
		
		if(! AccountValidatorUtil.isEmail(userToken.getEmail())) {
			throw new WeiboException("邮箱格式不正确");
		}
		// 判定密码相同与否
		if(!(userToken.getPassword().equals(userToken.getRpassword()))){
			throw new WeiboException("两次密码不一致");
		}
		
		// 整理数据，插入数据库
		User user = new User();
		PropertyUtils.copyProperties(user, userToken);
		user.setUuid(UUIDUtils.getUUID());
		user.setNickname("新用户");
		user.setHeadimg("/img/headImg/def.jpg");
		user.setWeibo(0);
		user.setFollow(0);
		user.setFollower(0);
		user.setDeleted((byte) 0);
		user.setStatus(DC.STATUS_NORMAL);
		user.setPassword(MD5.getMD5(user.getPassword()));
		userMapper.insertSelective(user);
	}

	public User login(String username,String password) throws WeiboException {
		
		// 数据校验
		if(StringUtils.isBlank(username)){
			throw new WeiboException("用户名不能为空");
		}
		// 账号是否存在
		List<User> list = userMapper.selectByEmailOrUsername(null, username);
		
		// 若存在，校验密码
		if(list.isEmpty() || !(list.get(0).getPassword().equals(MD5.getMD5(password)))){
			throw new WeiboException("用户名或者密码错误");
		}
		// 返回数据不为空，则校验成功
		return list.get(0);
	}
	public void findPassword(User user) throws Exception {
		List<User> selectByEmailOrUsername = userMapper.selectByEmailOrUsername(null, user.getUsername());
		if (!selectByEmailOrUsername.isEmpty()) {
			User user2 = selectByEmailOrUsername.get(0);
			
			// 获取6位长度随机密码
			String pwd = PasswordUtil.getRandomString(6);
			user2.setPassword(MD5.getMD5(pwd));
			userMapper.updateByUserName(user2);
			Mail.send(user2.getEmail(), user2.getUsername(),pwd);
		} else {
			throw new WeiboException("账号或邮箱错误");
		}

	}

	public void chickUserNameExist(String username) throws WeiboException {
		if(StringUtils.isBlank(username)){
			throw new WeiboException("用户名不能为空");
		}
		List<User> list = userMapper.selectByEmailOrUsername(null, username);
		if (!list.isEmpty()) {
			throw new WeiboException("用户名存在");
		}
	}

	public void chickEmailExist(String email) throws WeiboException {
		if(StringUtils.isBlank(email)){
			throw new WeiboException("邮箱不能为空");
		}
		List<User> list = userMapper.selectByEmailOrUsername(email, null);
		if (!list.isEmpty()) {
			throw new WeiboException("该邮箱已经被注册");
		}
	}

	@Override
	public User changeUserInfo(User user) throws WeiboException {
		userMapper.updateByPrimaryKeySelective(user);
		return user;
	}

	@Override
	public User changeUserPassword(ChangePwdUser user) throws WeiboException {
		User selectByPrimaryKey = userMapper.selectByPrimaryKey(user.getUuid());
		if(selectByPrimaryKey.getPassword().equals(MD5.getMD5(user.getOldPassword()))) {
			selectByPrimaryKey.setPassword(MD5.getMD5(user.getNewPassword()));
			userMapper.updateByPrimaryKeySelective(selectByPrimaryKey);
		}else {
			throw new WeiboException("密码错误！");
		}
		return selectByPrimaryKey;
	}

	@Override
	public PaginatedList<UserVo> getFans(String login,UserCriterua criterua) throws Exception {
		// TODO  分页没做
		
		// 获取粉丝ids列表
		FollowFollowerExample example = new FollowFollowerExample();
		example.createCriteria().andFollowedEqualTo(criterua.getUuid());
		List<FollowFollower> list = followFollowerMapper.selectByExample(example);
		if(list.isEmpty()) {
			return new PaginatedList<UserVo>();
		}
		
		
		// 获取粉丝详细信息
		List<User> users = userMapper.selectByUuids(CollectionUtil.FiledToList(list, "follow", String.class));

		// 封装信息
		List<UserVo> resu = new ArrayList<>();
		for (User user : users) {
			UserVo vo = new UserVo();
			PropertyUtils.copyProperties(vo, user);

			// 我是否关注 此人
			FollowFollowerExample example2 = new FollowFollowerExample();
			example2.createCriteria().andFollowedEqualTo(user.getUuid()).andFollowEqualTo(login);
			List<FollowFollower> list2 = followFollowerMapper.selectByExample(example2);
			if (CollectionUtils.isNotEmpty(list2)) {
				vo.setMutual((byte) 1);
			}else {
				vo.setMutual((byte) 0);
			}

			resu.add(vo);
		}

		PaginatedList<UserVo> result = new PaginatedList<>();
		result.setPagination(criterua);
		result.setResult(resu);

		return result;
	}

	@Override
	public PaginatedList<UserVo> getFollower(String login,UserCriterua criterua) throws Exception {
		// 获取关注ids列表
		FollowFollowerExample example = new FollowFollowerExample();
		example.createCriteria().andFollowEqualTo(criterua.getUuid());
		List<FollowFollower> list = followFollowerMapper.selectByExample(example);

		// 获取关注者详细信息
		List<User> users = userMapper.selectByUuids(CollectionUtil.FiledToList(list, "followed", String.class));

		// 封装信息
		List<UserVo> resu = new ArrayList<>();
		for (User user : users) {
			UserVo vo = new UserVo();
			PropertyUtils.copyProperties(vo, user);

			// 我是否关注 此人
			FollowFollowerExample example2 = new FollowFollowerExample();
			example2.createCriteria().andFollowedEqualTo(user.getUuid()).andFollowEqualTo(login);
			List<FollowFollower> list2 = followFollowerMapper.selectByExample(example2);
			if (CollectionUtils.isNotEmpty(list2)) {
				vo.setMutual((byte) 1);
			}else {
				vo.setMutual((byte) 0);
			}

			resu.add(vo);
		}
		
		
		PaginatedList<UserVo> result = new PaginatedList<>();
		result.setPagination(criterua);
		result.setResult(resu);

		return result;
	}

	@Override
	public void unFollow(String me, String he) throws Exception {
		FollowFollowerExample example = new FollowFollowerExample();
		example.createCriteria().andFollowEqualTo(me).andFollowedEqualTo(he);
		List<FollowFollower> select1 = followFollowerMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(select1)) {
			throw new Exception("您未关注TA。");
		}
		
		followFollowerMapper.deleteByPrimaryKey(select1.get(0).getId());
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

	@Override
	public UserVo getUserById(String username,String loginId)  {
		UserVo vo = new UserVo();
		
		
		UserExample uuexample = new UserExample();
		uuexample.createCriteria().andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(uuexample );
		User user = list.get(0);
		try {
			PropertyUtils.copyProperties(vo, user);
		} catch (Exception e) {
			// 不会发生
			e.printStackTrace();
		}
		
		FollowFollowerExample example = new FollowFollowerExample();
		example.createCriteria().andFollowedEqualTo(user.getUuid()).andFollowEqualTo(loginId);
		List<FollowFollower> selectByExample = followFollowerMapper.selectByExample(example );
		if(!CollectionUtils.isEmpty(selectByExample)) {
			vo.setMutual((byte)1);
		}else {
			vo.setMutual((byte)0);
		}
		if(user.getUuid().equals(loginId)) {
			vo.setMutual((byte)9);
		}
		return vo;
	}

}
