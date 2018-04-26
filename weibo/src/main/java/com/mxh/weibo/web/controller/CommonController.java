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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.Pagination;
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
    public BaseResponse<String> upload(HttpServletRequest request) throws Exception {
    	BaseResponse<String> res = new BaseResponse<>();
    	
    	
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");

        String rootDir = request.getRealPath("/");
        String picName = "name --";
        
        // 截取文件的扩展名(如.jpg)
        String oriName = file.getOriginalFilename();
        String extName = oriName.substring(oriName.lastIndexOf("."));
        
        //文件夹不存在则创建

        String newName = new Date().getTime()+"_"+oriName;
        File tempFile = new File(newName);
        file.transferTo(tempFile);


        return res;
    }
	
}
