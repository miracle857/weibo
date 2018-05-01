package com.mxh.weibo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.mxh.weibo.common.model.User;

@Controller
public class BaseController {
	
    public User getLogin(HttpServletRequest request) {
        return (User)request.getSession().getAttribute("user");
    }
	
}
