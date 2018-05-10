package com.mxh.weibo.sevice;

import java.util.List;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.Like;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.WeiboCriteria;
import com.mxh.weibo.common.o.vo.WeiboVo;

public interface WeiboService {
	
	/**
	 * 展示一定数量的weibo
	 * @param weibo
	 * @return
	 */
	PaginatedList<WeiboVo> listWeibo(WeiboCriteria criteria,String loginUuid);
	
	/**
	 * 发布weibo
	 * @param weibo
	 * @return 
	 */
	Weibo publishWeibo(Weibo weibo);
	
	/**
	 * 删除
	 * @param weibo
	 */
	void deleteWeibo(Weibo weibo);

	List<WeiboVo> listWeiboByUuid(String uuid);
	
	void likeWeibo(Like like) throws Exception;
	
	void cancelLikeWeibo(Like like) throws Exception;
}
