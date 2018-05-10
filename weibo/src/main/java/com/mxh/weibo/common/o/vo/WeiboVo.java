package com.mxh.weibo.common.o.vo;

import java.io.Serializable;
import java.util.Date;

public class WeiboVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	private byte like;
	
	
	public byte getLike() {
		return like;
	}
	public void setLike(byte like) {
		this.like = like;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUserUsername() {
		return userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserHeadimg() {
		return userHeadimg;
	}
	public void setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public Integer getLiked() {
		return liked;
	}
	public void setLiked(Integer liked) {
		this.liked = liked;
	}
	public String getReplyUuid() {
		return replyUuid;
	}
	public void setReplyUuid(String replyUuid) {
		this.replyUuid = replyUuid;
	}
	public Byte getDeleted() {
		return deleted;
	}
	public void setDeleted(Byte deleted) {
		this.deleted = deleted;
	}
	public Integer getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}
	
	

}
