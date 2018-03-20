package com.mxh.weibo.common.model;

import java.io.Serializable;
import java.util.Date;

public class Weibo implements Serializable {

	/**
	 * Column: weibo_weibo.UUID
	 * @mbggenerated
	 */
	private String uuid;
	/**
	 * 用户名. Column: weibo_weibo.USER_USERNAME
	 * @mbggenerated
	 */
	private String userUsername;
	/**
	 * 用户昵称. Column: weibo_weibo.USER_NICKNAME
	 * @mbggenerated
	 */
	private String userNickname;
	/**
	 * 用户头像. Column: weibo_weibo.USER_HEADIMG
	 * @mbggenerated
	 */
	private String userHeadimg;
	/**
	 * 发布时间. Column: weibo_weibo.PUBLISH_TIME
	 * @mbggenerated
	 */
	private Date publishTime;
	/**
	 * 内容. Column: weibo_weibo.CONTENT
	 * @mbggenerated
	 */
	private String content;
	/**
	 * 赞. Column: weibo_weibo.PRAISE
	 * @mbggenerated
	 */
	private Integer praise;
	/**
	 * 收藏. Column: weibo_weibo.LIKED
	 * @mbggenerated
	 */
	private Integer liked;
	/**
	 * 回复UUID. Column: weibo_weibo.REPLY_UUID
	 * @mbggenerated
	 */
	private String replyUuid;
	/**
	 * Column: weibo_weibo.DELETED
	 * @mbggenerated
	 */
	private Byte deleted;
	/**
	 * 微博回复数目. Column: weibo_weibo.REPLY_NUM
	 * @mbggenerated
	 */
	private Integer replyNum;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return  the value of weibo_weibo.UUID
	 * @mbggenerated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid  the value for weibo_weibo.UUID
	 * @mbggenerated
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return  the value of weibo_weibo.USER_USERNAME
	 * @mbggenerated
	 */
	public String getUserUsername() {
		return userUsername;
	}

	/**
	 * @param userUsername  the value for weibo_weibo.USER_USERNAME
	 * @mbggenerated
	 */
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	/**
	 * @return  the value of weibo_weibo.USER_NICKNAME
	 * @mbggenerated
	 */
	public String getUserNickname() {
		return userNickname;
	}

	/**
	 * @param userNickname  the value for weibo_weibo.USER_NICKNAME
	 * @mbggenerated
	 */
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	/**
	 * @return  the value of weibo_weibo.USER_HEADIMG
	 * @mbggenerated
	 */
	public String getUserHeadimg() {
		return userHeadimg;
	}

	/**
	 * @param userHeadimg  the value for weibo_weibo.USER_HEADIMG
	 * @mbggenerated
	 */
	public void setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
	}

	/**
	 * @return  the value of weibo_weibo.PUBLISH_TIME
	 * @mbggenerated
	 */
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishTime  the value for weibo_weibo.PUBLISH_TIME
	 * @mbggenerated
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * @return  the value of weibo_weibo.CONTENT
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content  the value for weibo_weibo.CONTENT
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return  the value of weibo_weibo.PRAISE
	 * @mbggenerated
	 */
	public Integer getPraise() {
		return praise;
	}

	/**
	 * @param praise  the value for weibo_weibo.PRAISE
	 * @mbggenerated
	 */
	public void setPraise(Integer praise) {
		this.praise = praise;
	}

	/**
	 * @return  the value of weibo_weibo.LIKED
	 * @mbggenerated
	 */
	public Integer getLiked() {
		return liked;
	}

	/**
	 * @param liked  the value for weibo_weibo.LIKED
	 * @mbggenerated
	 */
	public void setLiked(Integer liked) {
		this.liked = liked;
	}

	/**
	 * @return  the value of weibo_weibo.REPLY_UUID
	 * @mbggenerated
	 */
	public String getReplyUuid() {
		return replyUuid;
	}

	/**
	 * @param replyUuid  the value for weibo_weibo.REPLY_UUID
	 * @mbggenerated
	 */
	public void setReplyUuid(String replyUuid) {
		this.replyUuid = replyUuid;
	}

	/**
	 * @return  the value of weibo_weibo.DELETED
	 * @mbggenerated
	 */
	public Byte getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted  the value for weibo_weibo.DELETED
	 * @mbggenerated
	 */
	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return  the value of weibo_weibo.REPLY_NUM
	 * @mbggenerated
	 */
	public Integer getReplyNum() {
		return replyNum;
	}

	/**
	 * @param replyNum  the value for weibo_weibo.REPLY_NUM
	 * @mbggenerated
	 */
	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}
}