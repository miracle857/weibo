package com.mxh.weibo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.Pagination;
import com.mxh.weibo.common.model.Reply;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.o.ReplyCriterua;
import com.mxh.weibo.common.o.vo.ReplyVo;
import com.mxh.weibo.common.util.PropertyUtil;
import com.mxh.weibo.sevice.ReplyService;
import com.mxh.weibo.web.BaseResponse;
import com.mxh.weibo.web.response.ResponsePageVo;

@Controller
@RequestMapping("/r")
public class ReplyController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReplyController.class);

	@Autowired
	private ReplyService replyService;

	@RequestMapping("/getReply")
	@ResponseBody
	public ResponsePageVo getReply(ReplyCriterua criterua) {
		ResponsePageVo response = new ResponsePageVo();

		PaginatedList<ReplyVo> replyByWBID = replyService.getReplyByWBID(criterua);
		response.setRows(replyByWBID.getResult());
		Pagination pagination = replyByWBID.getPagination();
		response.setPage(pagination.getPage());
		response.setTotal(pagination.getTotal());
		response.setPageCount(pagination.getTotalPage());
		response.setPageSize(pagination.getPagesize());
		return response;
	}

	@RequestMapping("/replyWeibo")
	@ResponseBody
	public BaseResponse<ReplyVo> replyWeibo(Reply reply) {
		BaseResponse<ReplyVo> res = new BaseResponse<>();

		User login = this.getLogin();
		reply.setUserId(login.getUuid());
		try {
			Reply publishReply = replyService.publishReply(reply);
			
			ReplyVo vo = new ReplyVo();
			PropertyUtil.copyProperties(vo, publishReply);
			vo.setUser(this.getLogin());
			
			res.setBody(vo);
			res.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			res.setSuccess(false);
			res.setMessage(e.getMessage());
		}

		return res;
	}

}
