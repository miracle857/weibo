package com.mxh.weibo.web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.o.UserCriterua;
import com.mxh.weibo.common.o.vo.UserVo;
import com.mxh.weibo.sevice.UserService;
import com.mxh.weibo.web.BaseResponse;

@Controller
public class CommonController extends BaseController{
	
	@Autowired
    private UserService userService;
	
	
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
        User user =  this.getLogin(request);
        String newName = user.getUuid()+extName;
        File tempFile = new File(realPath+"img"+File.separator+"headImg"+File.separator+newName);
        file.transferTo(tempFile);
        res.setSuccess(true);
        return res;
    }
	
    
    @RequestMapping("/load/fans/{uuid}")
    public String loadFans(HttpServletRequest request,@PathVariable String uuid) {
		UserCriterua vo = new UserCriterua();
		vo.setUuid(uuid);
		try {
			PaginatedList<UserVo> fans = userService.getFans(this.getLogin(request).getUuid(), vo);
			request.setAttribute("reqFans", fans.getResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "header/fans-module";
    }
    
    @RequestMapping("/load/follow/{uuid}")
    public String loadFollow(HttpServletRequest request,@PathVariable String uuid) {
    	UserCriterua vo = new UserCriterua();
		vo.setUuid(uuid);
		try {
			PaginatedList<UserVo> fans = userService.getFollower(this.getLogin(request).getUuid(), vo);
			request.setAttribute("reqFollows", fans.getResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "header/follow-module";
    }
}
