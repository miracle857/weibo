package com.mxh.weibo.common.model;

import java.io.Serializable;

public class Like implements Serializable {
    /**
     * Column: weibo_like.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * 被赞的微博.
     * Column: weibo_like.LIKED_WEIBO
     *
     * @mbggenerated
     */
    private String likedWeibo;

    /**
     * 点赞的人.
     * Column: weibo_like.LIKED_USER
     *
     * @mbggenerated
     */
    private String likedUser;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return the value of weibo_like.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id the value for weibo_like.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the value of weibo_like.LIKED_WEIBO
     *
     * @mbggenerated
     */
    public String getLikedWeibo() {
        return likedWeibo;
    }

    /**
     *
     * @param likedWeibo the value for weibo_like.LIKED_WEIBO
     *
     * @mbggenerated
     */
    public void setLikedWeibo(String likedWeibo) {
        this.likedWeibo = likedWeibo;
    }

    /**
     * @return the value of weibo_like.LIKED_USER
     *
     * @mbggenerated
     */
    public String getLikedUser() {
        return likedUser;
    }

    /**
     *
     * @param likedUser the value for weibo_like.LIKED_USER
     *
     * @mbggenerated
     */
    public void setLikedUser(String likedUser) {
        this.likedUser = likedUser;
    }
}