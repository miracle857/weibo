package com.mxh.weibo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.model.WeiboExample;
import com.mxh.weibo.common.o.WeiboCriteria;
import com.mxh.weibo.common.o.vo.WeiboVo;

public interface WeiboMapper {

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	long countByExample(WeiboExample example);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	int deleteByExample(WeiboExample example);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String uuid);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	int insert(Weibo record);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	int insertSelective(Weibo record);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	List<Weibo> selectByExample(WeiboExample example);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	Weibo selectByPrimaryKey(String uuid);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Weibo record, @Param("example") WeiboExample example);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") Weibo record, @Param("example") WeiboExample example);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Weibo record);

	/**
	 * This method corresponds to the database table weibo_weibo
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Weibo record);

	List<WeiboVo> selectByWeiboCriteria(WeiboCriteria criteria);

	int countByWeiboCriteria(WeiboCriteria criteria);

	void updateReplyNumPlus1(Weibo record);
}