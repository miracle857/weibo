package com.mxh.weibo.common.model;

import java.io.Serializable;

public class FollowFollower implements Serializable {

	/**
	 * Column: weibo_follow_follower.ID
	 * @mbggenerated
	 */
	private Integer id;
	/**
<<<<<<< HEAD
	 * 关注. Column: weibo_follow_follower.FOLLOW
	 * @mbggenerated
	 */
	private String follow;
	/**
	 * 被关注. Column: weibo_follow_follower.FOLLOWED
	 * @mbggenerated
	 */
	private String followed;
=======
	 * Column: weibo_follow_follower.FOLLOW
	 * @mbggenerated
	 */
	private String follow;
	/**
	 * Column: weibo_follow_follower.FOLLOWER
	 * @mbggenerated
	 */
	private String follower;
>>>>>>> branch 'master' of https://github.com/LzVae/WeiBo.git
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
<<<<<<< HEAD
	 * @return  the value of weibo_follow_follower.FOLLOWED
	 * @mbggenerated
	 */
	public String getFollowed() {
		return followed;
=======
	 * @return  the value of weibo_follow_follower.FOLLOWER
	 * @mbggenerated
	 */
	public String getFollower() {
		return follower;
>>>>>>> branch 'master' of https://github.com/LzVae/WeiBo.git
	}

	/**
<<<<<<< HEAD
	 * @param followed  the value for weibo_follow_follower.FOLLOWED
	 * @mbggenerated
	 */
	public void setFollowed(String followed) {
		this.followed = followed;
=======
	 * @param follower  the value for weibo_follow_follower.FOLLOWER
	 * @mbggenerated
	 */
	public void setFollower(String follower) {
		this.follower = follower;
>>>>>>> branch 'master' of https://github.com/LzVae/WeiBo.git
	}
}