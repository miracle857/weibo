package com.mxh.weibo.sevice.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.Like;
import com.mxh.weibo.common.model.LikeExample;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.WeiboCriteria;
import com.mxh.weibo.common.o.vo.WeiboVo;
import com.mxh.weibo.common.util.PropertyUtil;
import com.mxh.weibo.common.util.UUIDUtils;
import com.mxh.weibo.dao.LikeMapper;
import com.mxh.weibo.dao.UserMapper;
import com.mxh.weibo.dao.WeiboMapper;
import com.mxh.weibo.sevice.WeiboService;

@Service
public class WeiboServiceImpl implements WeiboService {

	@Autowired
	private WeiboMapper weiboMapper;

	@Autowired
	public UserMapper userMapper;
	
	@Autowired
	public LikeMapper likeMapper;

	@Override
	public PaginatedList<WeiboVo> listWeibo(WeiboCriteria criteria,String loginUuid) {
		int total = weiboMapper.countByWeiboCriteria(criteria);
		criteria.setTotal(total); // 计算数量，得出分页信息
		
		List<Weibo> list = weiboMapper.selectByWeiboCriteria(criteria);
		
		List<WeiboVo> result = new ArrayList<>();
		for (Weibo weibo : list) {
			WeiboVo vo = new WeiboVo();
			
			PropertyUtil.copyProperties(vo, weibo);
			
			LikeExample example = new LikeExample();
			example.createCriteria().andLikedUserEqualTo(loginUuid).andLikedWeiboEqualTo(weibo.getUuid());
			List<Like> list2 = likeMapper.selectByExample(example );
			if(!list2.isEmpty()) {
				vo.setLike((byte)1);
			}else {
				vo.setLike((byte)0);
			}
			
			result.add(vo);
		}
		
		
		PaginatedList<WeiboVo> paginatedList = new PaginatedList<>();
		paginatedList.setResult(result);
		paginatedList.setPagination(criteria);
		return paginatedList;
	}

	@Override
	public Weibo publishWeibo(Weibo weibo) {
		weibo.setUuid(UUIDUtils.getUUID());
		weibo.setLiked(0);
		weibo.setPraise(0);
		weibo.setPublishTime(new Date()); 

		User user = userMapper.selectByPrimaryKey(weibo.getUserId());
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
	public List<WeiboVo> listWeiboByUuid(String uuid) {
		User user = userMapper.selectByPrimaryKey(uuid);
		
		WeiboCriteria criteria = new WeiboCriteria();
		criteria.setUserUsername(user.getUsername());
		List<Weibo> selectByWeiboCriteria = weiboMapper.selectByWeiboCriteria(criteria );
		
		List<WeiboVo> result = new ArrayList<>();
		for (Weibo weibo : selectByWeiboCriteria) {
			WeiboVo vo = new WeiboVo();
			
			PropertyUtil.copyProperties(vo, weibo);
			
			LikeExample example = new LikeExample();
			example.createCriteria().andLikedUserEqualTo(uuid).andLikedWeiboEqualTo(weibo.getUuid());
			List<Like> list = likeMapper.selectByExample(example );
			if(!list.isEmpty()) {
				vo.setLike((byte)1);
			}else {
				vo.setLike((byte)0);
			}
			
			result.add(vo);
		}
		
		return result;
	}

	@Override
	public void likeWeibo(Like like) throws Exception {
		LikeExample example = new LikeExample();
		example.createCriteria().andLikedUserEqualTo(like.getLikedUser()).andLikedWeiboEqualTo(like.getLikedWeibo());
		List<Like> selectByExample = likeMapper.selectByExample(example );
		if(selectByExample.isEmpty()) {
			likeMapper.insertSelective(like);
		}else {
			throw new Exception("您已经点赞！");
		}
	}

	@Override
	public void cancelLikeWeibo(Like like) throws Exception {
		LikeExample example = new LikeExample();
		example.createCriteria().andLikedUserEqualTo(like.getLikedUser()).andLikedWeiboEqualTo(like.getLikedWeibo());
		List<Like> selectByExample = likeMapper.selectByExample(example);
		if(!selectByExample.isEmpty()) {
			likeMapper.deleteByPrimaryKey(selectByExample.get(0).getId());
		}else {
			throw new Exception("没有点赞呢！");
		}
	}

}
