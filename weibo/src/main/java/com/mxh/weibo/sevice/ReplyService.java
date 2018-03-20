package com.mxh.weibo.sevice;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.Reply;
import com.mxh.weibo.common.o.ReplyCriterua;

public interface ReplyService {

    PaginatedList<Reply> getReplyByWBID(ReplyCriterua criterua);

	Reply publishReply(Reply reply) throws Exception;

    void deleteReply(Reply reply);

}
