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
	 * 个人说明. Column: weibo_user.COMMENT
	 * 
	 * @mbggenerated
	 */
	private String comment;
	/**
	 * 账户状态. Column: weibo_user.STATUS
	 * 
	 * @mbggenerated
	 */
	private String status;
	/**
	 * 邮箱.Column: weibo_user.EMAIL
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
}