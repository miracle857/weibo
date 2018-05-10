package com.mxh.weibo.dao;

import com.mxh.weibo.common.model.Like;
import com.mxh.weibo.common.model.LikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikeMapper {

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	long countByExample(LikeExample example);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	int deleteByExample(LikeExample example);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	int insert(Like record);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	int insertSelective(Like record);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	List<Like> selectByExample(LikeExample example);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	Like selectByPrimaryKey(Integer id);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Like record, @Param("example") LikeExample example);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") Like record, @Param("example") LikeExample example);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Like record);

	/**
	 * This method corresponds to the database table weibo_like
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Like record);
}