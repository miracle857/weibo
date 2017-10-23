package com.mxh.weibo.sevice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.dto.criteria.WeiboCriteria;
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
	public PaginatedList<Weibo> listWeibo(WeiboCriteria criteria) {
		int total = weiboMapper.countByWeiboCriteria(criteria);
		criteria.setTotal(total); // 计算数量，得出分页信息
		
		List<Weibo> list = weiboMapper.selectByWeiboCriteria(criteria);
		PaginatedList<Weibo> result = new PaginatedList<>();
		result.setResult(list);
		result.setPagination(criteria);
		return result;
	}

	@Override
	public Weibo publishWeibo(Weibo weibo) {
		weibo.setUuid(UUIDUtils.getUUID());
		weibo.setLiked(0);
		weibo.setPraise(0);
		weibo.setPublishTime(new Date()); // 到时候传回前台会不会出问题？？？

		User user = userMapper.selectByEmailOrUsername(null, weibo.getUserUsername());
		user.setWeibo(user.getWeibo() + 1);

		weiboMapper.insertSelective(weibo);
		userMapper.updateByPrimaryKeySelective(user);

		return weibo;
	}

	@Override
	public void deleteWeibo(Weibo weibo) {
		// TODO Auto-generated method stub

	}

}
