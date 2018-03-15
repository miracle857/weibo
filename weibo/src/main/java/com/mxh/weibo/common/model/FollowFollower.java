package com.mxh.weibo.common.model;

import java.io.Serializable;

public class FollowFollower implements Serializable {

	/**
	 * Column: weibo_follow_follower.ID
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * 关注. Column: weibo_follow_follower.FOLLOW
	 * @mbggenerated
	 */
	private String follow;
	/**
	 * 被关注. Column: weibo_follow_follower.FOLLOWED
	 * @mbggenerated
	 */
	private String followed;
	/**
	 * 互相关注（1.互相 0.不）. Column: weibo_follow_follower.MUTUAL
	 * @mbggenerated
	 */
	private Byte mutual;
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
	 * @return  the value of weibo_follow_follower.FOLLOWED
	 * @mbggenerated
	 */
	public String getFollowed() {
		return followed;
	}

	/**
	 * @param followed  the value for weibo_follow_follower.FOLLOWED
	 * @mbggenerated
	 */
	public void setFollowed(String followed) {
		this.followed = followed;
	}

	/**
	 * @return  the value of weibo_follow_follower.MUTUAL
	 * @mbggenerated
	 */
	public Byte getMutual() {
		return mutual;
	}

	/**
	 * @param mutual  the value for weibo_follow_follower.MUTUAL
	 * @mbggenerated
	 */
	public void setMutual(Byte mutual) {
		this.mutual = mutual;
	}


}