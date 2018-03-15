package com.mxh.weibo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.Pagination;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.WeiboCriteria;
import com.mxh.weibo.sevice.WeiboService;
import com.mxh.weibo.web.BaseResponse;
import com.mxh.weibo.web.response.ResponsePageVo;

@Controller
@RequestMapping("/w")
public class WeiboController {
	
	@Autowired
	private WeiboService weiboService;
	
	@RequestMapping("/publish")
	@ResponseBody
	public BaseResponse<Weibo> publishWeibo(Weibo weibo){
		return new BaseResponse<>(true,"发布成功",weiboService.publishWeibo(weibo));
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public ResponsePageVo listWeibo(WeiboCriteria criteria){
		PaginatedList<Weibo> paginatedList = weiboService.listWeibo(criteria);
		Pagination pagination = paginatedList.getPagination();
		List<Weibo> result = paginatedList.getResult();
		ResponsePageVo response = new ResponsePageVo();
		response.setRows(result);
		response.setPage(pagination.getPage());
		response.setTotal(pagination.getTotal());
		response.setPageCount(pagination.getTotalPage());
		response.setPageSize(pagination.getPagesize());
		return response;
	}
}
