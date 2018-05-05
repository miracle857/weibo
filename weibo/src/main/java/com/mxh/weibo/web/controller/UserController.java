package com.mxh.weibo.web.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.exception.WeiboException;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.o.UserToken;
import com.mxh.weibo.common.o.vo.UserVo;
import com.mxh.weibo.sevice.UserService;
import com.mxh.weibo.web.BaseResponse;

@Controller
public class UserController extends BaseController{

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
    
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
    	request.getSession().removeAttribute("user");
    	return "redirect:main.do";
    }
    
    @RequestMapping("/findPwd")
    @ResponseBody
    public BaseResponse<Void> findPwd(HttpServletRequest request,User token) {
    	BaseResponse<Void> res = new BaseResponse<>();
    	try {
			userService.findPassword(token);
			res.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setSuccess(false);
			res.setMessage(e.getMessage());
		}
    	return res;
    }
    
    @RequestMapping("/set/{set}")
    public String toSetting(HttpServletRequest request,@PathVariable String set) {
    	//User user =  (User)request.getSession().getAttribute("user");
    	return set;
    }
    
    @RequestMapping("/detail/{username}")
    public String toDetail(HttpServletRequest request,@PathVariable String username) {
    	
    	// TODO ，这里要提防 ID 不存在的情况，以后再补
    	
    	UserVo user = userService.getUserById(username,this.getLogin(request).getUuid());
    	request.setAttribute("detUser", user);
    	return "detail";
    }
    
    @RequestMapping("/save")
    public BaseResponse<User> save(HttpServletRequest request,User user) {
    	
    	BaseResponse<User> res = new BaseResponse<>();
    	user.setUuid(this.getLogin(request).getUuid());
    	try {
			userService.changeUserInfo(user);
			res.setBody(user);
			res.setSuccess(true);
		} catch (WeiboException e) {
			res.setMessage(e.getMessage());
			e.printStackTrace();
		}
    	return res;
    }
    
/*    @RequestMapping("/set/info")
    public String toInfo(HttpServletRequest request) {
    	User user =  (User)request.getSession().getAttribute("user");
    	return "info";
    }*/
    
    @RequestMapping("/op/{type}/id/{uuid}")
    @ResponseBody
    public BaseResponse<String> follow(@PathVariable String type,@PathVariable String uuid,HttpServletRequest req){
    	BaseResponse<String> res = new BaseResponse<>();
		try {
			if("follow".equals(type)) {
				userService.follow(this.getLogin(req).getUuid(), uuid);
				res.setMessage("关注成功");
			}else if("unfollow".equals(type)) {
				userService.unFollow(this.getLogin(req).getUuid(), uuid);
				res.setMessage("取消关注成功");
			}else {
				throw new Exception("未知的操作！");
			}
			res.setBody(type);
			res.setSuccess(true);
		} catch (Exception e) {
			res.setMessage(e.getMessage());
			LOGGER.error(e.getMessage());
		}
    	return res;
    }

}
