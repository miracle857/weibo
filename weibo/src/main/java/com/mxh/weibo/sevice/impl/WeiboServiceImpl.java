package com.mxh.weibo.sevice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.exception.WeiboException;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.util.UUIDUtils;
import com.mxh.weibo.dao.UserMapper;
import com.mxh.weibo.dao.WeiboMapper;
import com.mxh.weibo.sevice.IWeiboService;

@Service
public class WeiboServiceImpl implements IWeiboService {

	@Autowired
	private WeiboMapper weiboMapper;

	@Autowired
	public UserMapper userMapper;

	@Override
	public List<Weibo> listWeibo(Weibo weibo) {
		// TODO 一次展示几条？ 分页? 还是不分页自动加载？
		return null;
	}

	@Override
	public Weibo publishWeibo(Weibo weibo) {
		weibo.setUuid(UUIDUtils.getUUID());
		weibo.setLike(0);
		weibo.setPraise(0);
		weibo.setPublishTime(new Date()); // 到时候传回前台会不会出问题？？？

		User user = userMapper.selectByEmailOrUsername(null, weibo.getUserUsername());
		user.setWeibo(user.getWeibo() + 1);

		// FIXME 要不要捕捉一些未知的异常....又感觉不可能会出现异常...
		weiboMapper.insertSelective(weibo);
		userMapper.updateByPrimaryKeySelective(user);

		return weibo;
	}

	@Override
	public void deleteWeibo(Weibo weibo) {
		// TODO Auto-generated method stub

	}

}
