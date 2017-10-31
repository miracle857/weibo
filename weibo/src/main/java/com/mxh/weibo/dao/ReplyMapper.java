package com.mxh.weibo.dao;

import com.mxh.weibo.common.model.Reply;
import com.mxh.weibo.common.model.ReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyMapper {

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	long countByExample(ReplyExample example);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	int deleteByExample(ReplyExample example);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String uuid);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	int insert(Reply record);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	int insertSelective(Reply record);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	List<Reply> selectByExample(ReplyExample example);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	Reply selectByPrimaryKey(String uuid);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Reply record);

	/**
	 * This method corresponds to the database table weibo_reply
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Reply record);
}