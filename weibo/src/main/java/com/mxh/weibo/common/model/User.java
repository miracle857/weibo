package com.mxh.weibo.common.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * Column: weibo_user.UUID
	 * 
	 * @mbggenerated
	 */
	private Integer uuid;
	/**
	 * 用户名. Column: weibo_user.USERNAME
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
	 * 密码. Column: weibo_user.PASSWORD
	 * 
	 * @mbggenerated
	 */
	private String password;
	/**
	 * 签名. Column: weibo_user.COMMENT
	 * 
	 * @mbggenerated
	 */
	private String comment;
	/**
	 * 状态. Column: weibo_user.STATUS
	 * 
	 * @mbggenerated
	 */
	private String status;
	/**
	 * 邮箱. Column: weibo_user.EMAIL
	 * 
	 * @mbggenerated
	 */
	private String email;
	/**
	 * Column: weibo_user.DELETED
	 * 
	 * @mbggenerated
	 */
	private Byte deleted;
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
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return the value of weibo_user.UUID
	 * @mbggenerated
	 */
	public Integer getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the value for weibo_user.UUID
	 * @mbggenerated
	 */
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the value of weibo_user.USERNAME
	 * @mbggenerated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the value for weibo_user.USERNAME
	 * @mbggenerated
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the value of weibo_user.NICKNAME
	 * @mbggenerated
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            the value for weibo_user.NICKNAME
	 * @mbggenerated
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the value of weibo_user.PASSWORD
	 * @mbggenerated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the value for weibo_user.PASSWORD
	 * @mbggenerated
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the value of weibo_user.COMMENT
	 * @mbggenerated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the value for weibo_user.COMMENT
	 * @mbggenerated
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the value of weibo_user.STATUS
	 * @mbggenerated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the value for weibo_user.STATUS
	 * @mbggenerated
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the value of weibo_user.EMAIL
	 * @mbggenerated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the value for weibo_user.EMAIL
	 * @mbggenerated
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the value of weibo_user.DELETED
	 * @mbggenerated
	 */
	public Byte getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the value for weibo_user.DELETED
	 * @mbggenerated
	 */
	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the value of weibo_user.HEADIMG
	 * @mbggenerated
	 */
	public String getHeadimg() {
		return headimg;
	}

	/**
	 * @param headimg
	 *            the value for weibo_user.HEADIMG
	 * @mbggenerated
	 */
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	/**
	 * @return the value of weibo_user.WEIBO
	 * @mbggenerated
	 */
	public Integer getWeibo() {
		return weibo;
	}

	/**
	 * @param weibo
	 *            the value for weibo_user.WEIBO
	 * @mbggenerated
	 */
	public void setWeibo(Integer weibo) {
		this.weibo = weibo;
	}

	/**
	 * @return the value of weibo_user.FOLLOW
	 * @mbggenerated
	 */
	public Integer getFollow() {
		return follow;
	}

	/**
	 * @param follow
	 *            the value for weibo_user.FOLLOW
	 * @mbggenerated
	 */
	public void setFollow(Integer follow) {
		this.follow = follow;
	}

	/**
	 * @return the value of weibo_user.FOLLOWER
	 * @mbggenerated
	 */
	public Integer getFollower() {
		return follower;
	}

	/**
	 * @param follower
	 *            the value for weibo_user.FOLLOWER
	 * @mbggenerated
	 */
	public void setFollower(Integer follower) {
		this.follower = follower;
	}
}