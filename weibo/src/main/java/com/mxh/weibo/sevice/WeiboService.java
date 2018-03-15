package com.mxh.weibo.sevice;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.WeiboCriteria;

public interface WeiboService {
	
	/**
	 * 展示一定数量的weibo
	 * @param weibo
	 * @return
	 */
	PaginatedList<Weibo> listWeibo(WeiboCriteria criteria);
	
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
}
