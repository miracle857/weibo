package com.mxh.weibo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.dto.UserToken;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.web.BaseResponse;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	public String login(User user,Model model){
		return "login";
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public BaseResponse<String> register(UserToken userToken){
		
		return null;
	}
}
