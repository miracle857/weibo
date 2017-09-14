package com.mxh.weibo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mxh.weibo.common.model.User;

@Controller
public class LoginController {

	@RequestMapping
	public String register(User user,Model model){
		return "1";
	}
}
