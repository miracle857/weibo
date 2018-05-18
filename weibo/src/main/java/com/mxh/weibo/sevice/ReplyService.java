package com.mxh.weibo.sevice;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.Reply;
import com.mxh.weibo.common.o.ReplyCriterua;
import com.mxh.weibo.common.o.vo.ReplyVo;

public interface ReplyService {

    PaginatedList<ReplyVo> getReplyByWBID(ReplyCriterua criterua);

	Reply publishReply(Reply reply) throws Exception;

    void deleteReply(Reply reply);

}
