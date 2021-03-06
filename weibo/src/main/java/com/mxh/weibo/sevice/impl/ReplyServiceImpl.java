package com.mxh.weibo.sevice.impl;

import static com.mxh.weibo.common.util.CheckNullable.checkNull;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.Reply;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.ReplyCriterua;
import com.mxh.weibo.common.o.vo.ReplyVo;
import com.mxh.weibo.common.util.UUIDUtils;
import com.mxh.weibo.dao.ReplyMapper;
import com.mxh.weibo.dao.WeiboMapper;
import com.mxh.weibo.sevice.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;

	@Autowired
	private WeiboMapper weiboMapper;

	@Override
	public PaginatedList<ReplyVo> getReplyByWBID(ReplyCriterua criterua) {



		List<ReplyVo> list = replyMapper.selectReplyByWeiboId(criterua);
		
		PaginatedList<ReplyVo> result = new PaginatedList<>();
		result.setPagination(criterua);
		result.setResult(list);
		return result;
	}

	@Override
	public Reply publishReply(Reply reply) throws Exception {
    	
		// Optional<Reply> op = Optional.of(reply);
		// op.map(x -> x.getUuid()).orElseThrow(Exception::new);

		checkNull(reply.getWeiboUuid(), "不存在此微博。");
		checkNull(reply.getContent(), "内容不能为空");

    	
		reply.setUuid(UUIDUtils.getUUID());
		reply.setDeleted((byte) 0);
		reply.setPublishtime(new Date());
		int insertSelective = replyMapper.insertSelective(reply);
		if (insertSelective > 0) {
			Weibo record = new Weibo();
			record.setUuid(reply.getWeiboUuid());
			weiboMapper.updateReplyNumPlus1(record);
		}
		return reply;
    }

	@Override
	public void deleteReply(Reply reply) {
		reply.setDeleted((byte) 1);
		replyMapper.updateByPrimaryKeySelective(reply);
	}
}
