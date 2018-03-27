package com.mxh.weibo.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.Pagination;
import com.mxh.weibo.common.model.Reply;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.ReplyCriterua;
import com.mxh.weibo.sevice.ReplyService;
import com.mxh.weibo.web.BaseResponse;
import com.mxh.weibo.web.response.ResponsePageVo;

@Controller("/r")
public class ReplyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReplyController.class);

    @Autowired
    private ReplyService replyService;

    @RequestMapping("/getReply")
    public ResponsePageVo getReply(ReplyCriterua criterua) {
    	ResponsePageVo response = new ResponsePageVo();
    	
    	PaginatedList<Reply> replyByWBID = replyService.getReplyByWBID(criterua);
    	response.setRows(replyByWBID.getResult());
    	Pagination pagination = replyByWBID.getPagination();
		response.setPage(pagination.getPage());
		response.setTotal(pagination.getTotal());
		response.setPageCount(pagination.getTotalPage());
		response.setPageSize(pagination.getPagesize());
		return response;
    }
    
    @RequestMapping("/replyWeibo")
    public BaseResponse<Reply> replyWeibo(){
    	
    	
		return null;
    }

}
