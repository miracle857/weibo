package com.mxh.weibo.common.o;

import com.mxh.weibo.common.Pagination;

public class ReplyCriterua extends Pagination{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

}
