package com.mxh.weibo.sevice;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.dto.criteria.ReplyCriterua;
import com.mxh.weibo.common.model.Reply;

public interface ReplyService {

    PaginatedList<Reply> getReplyByWBID(ReplyCriterua criterua);

    Reply publishReply(Reply reply);

    void deleteReply(Reply reply);

}
