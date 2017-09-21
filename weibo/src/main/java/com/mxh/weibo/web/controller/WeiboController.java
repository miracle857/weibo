package com.mxh.weibo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.sevice.IWeiboService;
import com.mxh.weibo.web.BaseResponse;

@Controller
@RequestMapping("/w")
public class WeiboController {
	
	@Autowired
	private IWeiboService weiboService;
	
	@RequestMapping("/publish")
	@ResponseBody
	public BaseResponse<Weibo> publishWeibo(Weibo weibo){
		weiboService.publishWeibo(weibo);
		return null;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public BaseResponse<List<Weibo>> listWeibo(){
		return null;
	}
}
