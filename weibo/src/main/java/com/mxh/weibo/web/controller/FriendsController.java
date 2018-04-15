package com.mxh.weibo.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mxh.weibo.common.o.vo.FriendVo;
import com.mxh.weibo.sevice.UserService;
import com.mxh.weibo.web.response.ResponsePageVo;

@Controller
public class FriendsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FriendsController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/fans")
    public ResponsePageVo getFans(FriendVo vo) {
    	ResponsePageVo res = new ResponsePageVo();
    	
    	return res;
    }

}
