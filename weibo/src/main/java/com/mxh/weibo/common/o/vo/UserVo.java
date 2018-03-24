package com.mxh.weibo.common.o.vo;

import java.io.Serializable;

public class UserVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Column: weibo_user.UUID
	 * 
	 * @mbggenerated
	 */
	private String uuid;
	/**
	 * 登录用户名. Column: weibo_user.USERNAME
	 * 
	 * @mbggenerated
	 */
	private String username;
	/**
	 * 昵称. Column: weibo_user.NICKNAME
	 * 
	 * @mbggenerated
	 */
	private String nickname;

	/**
	 * 个人说明. Column: weibo_user.COMMENT
	 * 
	 * @mbggenerated
	 */
	private String comment;

	/**
	 * 头像. Column: weibo_user.HEADIMG
	 * 
	 * @mbggenerated
	 */
	private String headimg;
	/**
	 * 微博数目. Column: weibo_user.WEIBO
	 * 
	 * @mbggenerated
	 */
	private Integer weibo;
	/**
	 * 关注. Column: weibo_user.FOLLOW
	 * 
	 * @mbggenerated
	 */
	private Integer follow;
	/**
	 * 粉丝. Column: weibo_user.FOLLOWER
	 * 
	 * @mbggenerated
	 */
	private Integer follower;

	private Byte mutual;

	public Byte getMutual() {
		return mutual;
	}

	public void setMutual(Byte mutual) {
		this.mutual = mutual;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public Integer getWeibo() {
		return weibo;
	}

	public void setWeibo(Integer weibo) {
		this.weibo = weibo;
	}

	public Integer getFollow() {
		return follow;
	}

	public void setFollow(Integer follow) {
		this.follow = follow;
	}

	public Integer getFollower() {
		return follower;
	}

	public void setFollower(Integer follower) {
		this.follower = follower;
	}

}
