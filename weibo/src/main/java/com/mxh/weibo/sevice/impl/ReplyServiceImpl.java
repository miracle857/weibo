package com.mxh.weibo.sevice.impl;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.Reply;
import com.mxh.weibo.common.o.ReplyCriterua;
import com.mxh.weibo.sevice.ReplyService;

public class ReplyServiceImpl implements ReplyService{

    @Override
    public PaginatedList<Reply> getReplyByWBID(ReplyCriterua criterua) {
        return null;
    }

    @Override
    public Reply publishReply(Reply reply) {
        return null;
    }

    @Override
    public void deleteReply(Reply reply) {

    }
}
