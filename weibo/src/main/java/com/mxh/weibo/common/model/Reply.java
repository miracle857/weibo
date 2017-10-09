package com.mxh.weibo.common.model;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
	/**
	 * Column: weibo_reply.UUID
	 *
	 * @mbggenerated
	 */
	private String uuid;

	/**
	 * 对应微博的UUID. Column: weibo_reply.WEIBO_UUID
	 *
	 * @mbggenerated
	 */
	private String weiboUuid;

	/**
	 * 用户名. Column: weibo_reply.USER_USERNAME
	 *
	 * @mbggenerated
	 */
	private String userUsername;

	/**
	 * 用户昵称. Column: weibo_reply.USER_NICKNAME
	 *
	 * @mbggenerated
	 */
	private String userNickname;

	/**
	 * 
	 * Column: weibo_reply.PUBLISHTIME
	 *
	 * @mbggenerated
	 */
	private Date publishtime;

	/**
	 * 内容. Column: weibo_reply.CONTENT
	 *
	 * @mbggenerated
	 */
	private String content;

	/**
	 * Column: weibo_reply.DELETED
	 *
	 * @mbggenerated
	 */
	private Byte deleted;

	/**
	 * Column: weibo_reply.REPLY_WHO
	 *
	 * @mbggenerated
	 */
	private String replyWho;

	/**
	 *
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return the value of weibo_reply.UUID
	 *
	 * @mbggenerated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 *
	 * @param uuid
	 *            the value for weibo_reply.UUID
	 *
	 * @mbggenerated
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the value of weibo_reply.WEIBO_UUID
	 *
	 * @mbggenerated
	 */
	public String getWeiboUuid() {
		return weiboUuid;
	}

	/**
	 *
	 * @param weiboUuid
	 *            the value for weibo_reply.WEIBO_UUID
	 *
	 * @mbggenerated
	 */
	public void setWeiboUuid(String weiboUuid) {
		this.weiboUuid = weiboUuid;
	}

	/**
	 * @return the value of weibo_reply.USER_USERNAME
	 *
	 * @mbggenerated
	 */
	public String getUserUsername() {
		return userUsername;
	}

	/**
	 *
	 * @param userUsername
	 *            the value for weibo_reply.USER_USERNAME
	 *
	 * @mbggenerated
	 */
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	/**
	 * @return the value of weibo_reply.USER_NICKNAME
	 *
	 * @mbggenerated
	 */
	public String getUserNickname() {
		return userNickname;
	}

	/**
	 *
	 * @param userNickname
	 *            the value for weibo_reply.USER_NICKNAME
	 *
	 * @mbggenerated
	 */
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	/**
	 * @return the value of weibo_reply.PUBLISHTIME
	 *
	 * @mbggenerated
	 */
	public Date getPublishtime() {
		return publishtime;
	}

	/**
	 *
	 * @param publishtime
	 *            the value for weibo_reply.PUBLISHTIME
	 *
	 * @mbggenerated
	 */
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	/**
	 * @return the value of weibo_reply.CONTENT
	 *
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 *
	 * @param content
	 *            the value for weibo_reply.CONTENT
	 *
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the value of weibo_reply.DELETED
	 *
	 * @mbggenerated
	 */
	public Byte getDeleted() {
		return deleted;
	}

	/**
	 *
	 * @param deleted
	 *            the value for weibo_reply.DELETED
	 *
	 * @mbggenerated
	 */
	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the value of weibo_reply.REPLY_WHO
	 *
	 * @mbggenerated
	 */
	public String getReplyWho() {
		return replyWho;
	}

	/**
	 *
	 * @param replyWho
	 *            the value for weibo_reply.REPLY_WHO
	 *
	 * @mbggenerated
	 */
	public void setReplyWho(String replyWho) {
		this.replyWho = replyWho;
	}
}