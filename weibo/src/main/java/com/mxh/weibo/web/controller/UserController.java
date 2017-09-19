package com.mxh.weibo.web.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.dto.UserToken;
import com.mxh.weibo.common.exception.WeiboException;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.sevice.IUserService;
import com.mxh.weibo.web.BaseResponse;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	@RequestMapping("/main")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public BaseResponse<User> login(UserToken user,Model model,HttpSession session){
		BaseResponse<User> res = new BaseResponse<>();
		try {
			User login = userService.login(user);
			session.setAttribute("user", login);
			res.setBody(login);
			res.setSuccess(true);
		} catch (WeiboException e) {
			res.setSuccess(false);
			res.setMessage(e.getMessage());
			LOGGER.info(e.getMessage(), e);
		}
		return res;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public BaseResponse<String> register(UserToken userToken){
		BaseResponse<String> res = new BaseResponse<>();
		try {
			userService.register(userToken);
			res.setSuccess(true);
			res.setMessage("注册成功！");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			res.setMessage(e.getMessage());
			res.setSuccess(false);
		}
		return res;
	}
}
