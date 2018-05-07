package com.mxh.weibo.sevice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.WeiboCriteria;
import com.mxh.weibo.common.util.UUIDUtils;
import com.mxh.weibo.dao.UserMapper;
import com.mxh.weibo.dao.WeiboMapper;
import com.mxh.weibo.sevice.WeiboService;

@Service
public class WeiboServiceImpl implements WeiboService {

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

		List<User> list = userMapper.selectByEmailOrUsername(null, weibo.getUserUsername());
		User user = list.get(0);
		user.setWeibo(user.getWeibo() + 1);

		weiboMapper.insertSelective(weibo);
		// TODO 打算用消息队列或websocket，做异步消息推送，有难度，待定..


		userMapper.updateByPrimaryKeySelective(user);

		return weibo;
	}

	@Override
	public void deleteWeibo(Weibo weibo) {
		// 1.删除 微博。2.账号下 微博条数-1 。 3.改微博下的所有回复删除

	}

	@Override
	public List<Weibo> listWeiboByUuid(String uuid) {
		User user = userMapper.selectByPrimaryKey(uuid);
		
		WeiboCriteria criteria = new WeiboCriteria();
		criteria.setUserUsername(user.getUsername());
		List<Weibo> selectByWeiboCriteria = weiboMapper.selectByWeiboCriteria(criteria );
		return selectByWeiboCriteria;
	}

}
