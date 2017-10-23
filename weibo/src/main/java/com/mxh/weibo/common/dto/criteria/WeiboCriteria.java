package com.mxh.weibo.common.dto.criteria;

import java.util.Date;

import com.mxh.weibo.common.Pagination;

/**
 * 入参 
 */
public class WeiboCriteria extends Pagination {

	private static final long serialVersionUID = 7422983808840828135L;

	/**
	 * Column: weibo_weibo.UUID
	 * 
	 * @mbggenerated
	 */
	private String uuid;
	/**
	 * �û���. Column: weibo_weibo.USER_USERNAME
	 * 
	 * @mbggenerated
	 */
	private String userUsername;
	/**
	 * �û��ǳ�. Column: weibo_weibo.USER_NICKNAME
	 * 
	 * @mbggenerated
	 */
	private String userNickname;
	/**
	 * �û�ͷ��. Column: weibo_weibo.USER_HEADIMG
	 * 
	 * @mbggenerated
	 */
	private String userHeadimg;
	/**
	 * ����ʱ��. Column: weibo_weibo.PUBLISH_TIME
	 * 
	 * @mbggenerated
	 */
	private Date publishTime;
	/**
	 * ����. Column: weibo_weibo.CONTENT
	 * 
	 * @mbggenerated
	 */
	private String content;
	/**
	 * ��. Column: weibo_weibo.PRAISE
	 * 
	 * @mbggenerated
	 */
	private Integer praise;
	/**
	 * �ղ�. Column: weibo_weibo.LIKED
	 * 
	 * @mbggenerated
	 */
	private Integer liked;
	/**
	 * �ظ�UUID. Column: weibo_weibo.REPLY_UUID
	 * 
	 * @mbggenerated
	 */
	private String replyUuid;

	/**
	 * @mbggenerated
	 */
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

}
