package com.mxh.weibo.common.model;

import java.io.Serializable;

public class FollowFollower implements Serializable {

	/**
	 * Column: weibo_follow_follower.ID
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * Column: weibo_follow_follower.FOLLOW
	 * @mbggenerated
	 */
	private String follow;
	/**
	 * Column: weibo_follow_follower.FOLLOWER
	 * @mbggenerated
	 */
	private String follower;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of weibo_follow_follower.ID
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id  the value for weibo_follow_follower.ID
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return  the value of weibo_follow_follower.FOLLOW
	 * @mbggenerated
	 */
	public String getFollow() {
		return follow;
	}

	/**
	 * @param follow  the value for weibo_follow_follower.FOLLOW
	 * @mbggenerated
	 */
	public void setFollow(String follow) {
		this.follow = follow;
	}

	/**
	 * @return  the value of weibo_follow_follower.FOLLOWER
	 * @mbggenerated
	 */
	public String getFollower() {
		return follower;
	}

	/**
	 * @param follower  the value for weibo_follow_follower.FOLLOWER
	 * @mbggenerated
	 */
	public void setFollower(String follower) {
		this.follower = follower;
	}
}