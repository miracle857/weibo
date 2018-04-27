package com.mxh.weibo.web.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.Pagination;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.WeiboCriteria;
import com.mxh.weibo.sevice.WeiboService;
import com.mxh.weibo.web.BaseResponse;
import com.mxh.weibo.web.response.ResponsePageVo;

@Controller
public class CommonController {
	
    //上传图片
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<String> upload(HttpServletRequest request,MultipartFile file) throws Exception {
    	BaseResponse<String> res = new BaseResponse<>();
    	
    	// 获取路径  **/webapp
        String realPath = request.getServletContext().getRealPath("/");
        //得到文件的名字 
        String oriName = file.getOriginalFilename();
        //截取文件的扩展名(如.jpg)
        String extName = oriName.substring(oriName.lastIndexOf("."));
        
        if(!".jpg".equals(extName)) {
        	 res.setSuccess(false);
        	 res.setMessage("文件后缀必须为jpg");
        	 return res;
        }
        User user =  (User)request.getSession().getAttribute("user");
        String newName = user.getUuid()+extName;
        File tempFile = new File(realPath+"img"+File.separator+"headImg"+File.separator+newName);
        file.transferTo(tempFile);
        res.setSuccess(true);
        return res;
    }
	
}
