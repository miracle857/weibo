package com.mxh.weibo.dao;

import com.mxh.weibo.common.model.FollowFollower;
import com.mxh.weibo.common.model.FollowFollowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FollowFollowerMapper {
    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    long countByExample(FollowFollowerExample example);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    int deleteByExample(FollowFollowerExample example);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    int insert(FollowFollower record);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    int insertSelective(FollowFollower record);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    List<FollowFollower> selectByExample(FollowFollowerExample example);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    FollowFollower selectByPrimaryKey(Integer id);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FollowFollower record, @Param("example") FollowFollowerExample example);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FollowFollower record, @Param("example") FollowFollowerExample example);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FollowFollower record);

    /**
     * This method corresponds to the database table weibo_follow_follower
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FollowFollower record);
}