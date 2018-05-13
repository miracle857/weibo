package com.mxh.weibo.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mxh.weibo.common.model.User;

@Controller
public class BaseController {
	
	private static final String _loginSessionKey="user"; 
	
	/**
	 * 获取登录人UUID
	 * @return
	 */
    public String getLoginUuid() {
    	User user = (User)getHttpSession().getAttribute(_loginSessionKey);
    	if(user != null) {
    		return user.getUuid();
    	}
        return null;
    }
    
    /**
     * 获取登录人
     * @return
     */
    public User getLogin() {
        return (User)getHttpSession().getAttribute(_loginSessionKey);
    }
	
     
    /** 
     * 获取当前请求session 
     * @return 
     */  
    public HttpServletRequest getHttpServletRequest(){  
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder  
                .getRequestAttributes())  
                .getRequest();  
        return request;  
    }     
    /** 
     * 获取当前请求session 
     * @return 
     */  
    public HttpSession getHttpSession(){  
        return getHttpServletRequest().getSession();  
    }  
}
