package com.mxh.weibo.sevice;

import java.util.List;

import com.mxh.weibo.common.model.Weibo;

public interface IWeiboService {
	
	/**
	 * 展示一定数量的weibo
	 * @param weibo
	 * @return
	 */
	List<Weibo> listWeibo(Weibo weibo);
	
	/**
	 * 发布weibo
	 * @param weibo
	 */
	void publishWeibo(Weibo weibo);
	
	/**
	 * 删除
	 * @param weibo
	 */
	void deleteWeibo(Weibo weibo);
}
