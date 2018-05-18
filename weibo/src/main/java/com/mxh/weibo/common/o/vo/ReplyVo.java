package com.mxh.weibo.common.o.vo;

import java.io.Serializable;
import java.util.Date;

import com.mxh.weibo.common.model.User;

public class ReplyVo implements Serializable {

	/**
	 * Column: weibo_reply.UUID
	 * 
	 * @mbggenerated
	 */
	private String uuid;

	private User user;
	/**
	 * 对应微博的UUID. Column: weibo_reply.WEIBO_UUID
	 * 
	 * @mbggenerated
	 */
	private String weiboUuid;
	/**
	 * 发布时间. Column: weibo_reply.PUBLISHTIME
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
	 * 回复谁. Column: weibo_reply.REPLY_WHO
	 * 
	 * @mbggenerated
	 */
	private String replyWho;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return the value of weibo_reply.UUID
	 * @mbggenerated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the value for weibo_reply.UUID
	 * @mbggenerated
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the value of weibo_reply.WEIBO_UUID
	 * @mbggenerated
	 */
	public String getWeiboUuid() {
		return weiboUuid;
	}

	/**
	 * @param weiboUuid
	 *            the value for weibo_reply.WEIBO_UUID
	 * @mbggenerated
	 */
	public void setWeiboUuid(String weiboUuid) {
		this.weiboUuid = weiboUuid;
	}

	/**
	 * @return the value of weibo_reply.PUBLISHTIME
	 * @mbggenerated
	 */
	public Date getPublishtime() {
		return publishtime;
	}

	/**
	 * @param publishtime
	 *            the value for weibo_reply.PUBLISHTIME
	 * @mbggenerated
	 */
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	/**
	 * @return the value of weibo_reply.CONTENT
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the value for weibo_reply.CONTENT
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the value of weibo_reply.DELETED
	 * @mbggenerated
	 */
	public Byte getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the value for weibo_reply.DELETED
	 * @mbggenerated
	 */
	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the value of weibo_reply.REPLY_WHO
	 * @mbggenerated
	 */
	public String getReplyWho() {
		return replyWho;
	}

	/**
	 * @param replyWho
	 *            the value for weibo_reply.REPLY_WHO
	 * @mbggenerated
	 */
	public void setReplyWho(String replyWho) {
		this.replyWho = replyWho;
	}
}