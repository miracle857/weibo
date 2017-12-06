package com.mxh.weibo.common.dto.criteria;

import com.mxh.weibo.common.Pagination;

import java.util.Date;

public class ReplyCriterua extends Pagination{
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getWeiboUuid() {
        return weiboUuid;
    }

    public void setWeiboUuid(String weiboUuid) {
        this.weiboUuid = weiboUuid;
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

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public String getReplyWho() {
        return replyWho;
    }

    public void setReplyWho(String replyWho) {
        this.replyWho = replyWho;
    }

    @Override
    public String toString() {
        return "ReplyCriterua{" +
                "uuid='" + uuid + '\'' +
                ", weiboUuid='" + weiboUuid + '\'' +
                ", userUsername='" + userUsername + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", publishtime=" + publishtime +
                ", content='" + content + '\'' +
                ", deleted=" + deleted +
                ", replyWho='" + replyWho + '\'' +
                '}';
    }
}
