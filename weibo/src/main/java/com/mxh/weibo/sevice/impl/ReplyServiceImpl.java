package com.mxh.weibo.sevice.impl;

import static com.mxh.weibo.common.util.CheckNullable.checkNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.Reply;
import com.mxh.weibo.common.model.ReplyExample;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.ReplyCriterua;
import com.mxh.weibo.dao.ReplyMapper;
import com.mxh.weibo.dao.WeiboMapper;
import com.mxh.weibo.sevice.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;

	@Autowired
	private WeiboMapper weiboMapper;

	@Override
	public PaginatedList<Reply> getReplyByWBID(ReplyCriterua criterua) {

		ReplyExample example = new ReplyExample();
		example.createCriteria().andWeiboUuidEqualTo(criterua.getWeiboUuid()).andDeletedEqualTo((byte) 0);
		List<Reply> list = replyMapper.selectByExample(example);

		PaginatedList<Reply> result = new PaginatedList<>();
		result.setPagination(criterua);
		result.setResult(list);
		return result;
	}

	@Override
	public Reply publishReply(Reply reply) throws Exception {
    	
		// Optional<Reply> op = Optional.of(reply);
		// op.map(x -> x.getUuid()).orElseThrow(Exception::new);

		checkNull(reply.getUuid(), "不存在此微博。");
		checkNull(reply.getContent(), "内容不能为空");
		// if(StringUtils.isBlank( reply.getUuid() )){
		// throw new WeiboException("不存在此微博。");
		// }
    	
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
