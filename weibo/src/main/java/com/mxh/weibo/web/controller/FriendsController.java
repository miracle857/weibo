package com.mxh.weibo.web.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.Pagination;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.o.UserCriterua;
import com.mxh.weibo.common.o.vo.UserVo;
import com.mxh.weibo.sevice.UserService;
import com.mxh.weibo.web.response.ResponsePageVo;

@Controller
@RequestMapping("/fri")
public class FriendsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FriendsController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/fans")
    @ResponseBody
    public ResponsePageVo getFans(UserCriterua vo,HttpSession session) {
    	ResponsePageVo res = new ResponsePageVo();
    	
    	User user = (User)session.getAttribute("user");
    	try {
			PaginatedList<UserVo> fans = userService.getFans(user.getUuid(), vo);
			res.setRows(fans.getResult());
			
	    	Pagination pagination = fans.getPagination();
	    	res.setPage(pagination.getPage());
	    	res.setTotal(pagination.getTotal());
			res.setPageCount(pagination.getTotalPage());
			res.setPageSize(pagination.getPagesize());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
    	return res;
    }
    
    @RequestMapping("/follower")
    @ResponseBody
    public ResponsePageVo getFollower(UserCriterua vo,HttpSession session) {
    	ResponsePageVo res = new ResponsePageVo();
    	
    	User user = (User)session.getAttribute("user");
    	try {
			PaginatedList<UserVo> fans = userService.getFollower(user.getUuid(), vo);
			res.setRows(fans.getResult());
			
	    	Pagination pagination = fans.getPagination();
	    	res.setPage(pagination.getPage());
	    	res.setTotal(pagination.getTotal());
			res.setPageCount(pagination.getTotalPage());
			res.setPageSize(pagination.getPagesize());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
    	return res;
    }

}
