package com.mxh.weibo.web.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.o.UserToken;
import com.mxh.weibo.sevice.UserService;
import com.mxh.weibo.web.BaseResponse;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping({"/main", ""})
    public String toLogin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    request.setAttribute("username", cookie.getValue());
                } else if ("pwd".equals(cookie.getName())) {
                    request.setAttribute("pwd", cookie.getValue());
                }
            }
        }
        return "login";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public BaseResponse<User> login(UserToken user, HttpServletRequest request) {
        BaseResponse<User> res = new BaseResponse<>();
        try {
//            ShiroToken token = new ShiroToken(user.getUsername(), user.getPassword());
//            Subject currentUser = SecurityUtils.getSubject();
//            currentUser.login(token);
        	User login = userService.login(user.getUsername(), user.getPassword());
            request.getSession().setAttribute("user", login);
            //res.setBody(login);
            res.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setSuccess(false);
            res.setMessage(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
        return res;
    }

    @RequestMapping("/register")
    @ResponseBody
    public BaseResponse<String> register(UserToken userToken) {
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
    
    @RequestMapping("/set/photo")
    public String toSetting(HttpServletRequest request) {
    	User user =  (User)request.getSession().getAttribute("user");
    	return "set";
    }

}
