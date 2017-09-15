package com.mxh.weibo.dao;

import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	long countByExample(UserExample example);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer uuid);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	int insert(User record);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	int insertSelective(User record);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	User selectByPrimaryKey(Integer uuid);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method corresponds to the database table weibo_user
	 * @mbggenerated
	 */
	int updateByPrimaryKey(User record);
	
	User selectByEmailOrUsername(@Param("email") String email, @Param("username") String username);

	int updateByUserName(User user);
}