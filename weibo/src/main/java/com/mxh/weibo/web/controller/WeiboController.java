package com.mxh.weibo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxh.weibo.common.PaginatedList;
import com.mxh.weibo.common.Pagination;
import com.mxh.weibo.common.model.Like;
import com.mxh.weibo.common.model.User;
import com.mxh.weibo.common.model.Weibo;
import com.mxh.weibo.common.o.WeiboCriteria;
import com.mxh.weibo.common.o.vo.WeiboVo;
import com.mxh.weibo.sevice.WeiboService;
import com.mxh.weibo.web.BaseResponse;
import com.mxh.weibo.web.response.ResponsePageVo;

@Controller
@RequestMapping("/w")
public class WeiboController extends BaseController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeiboController.class);
	
	@Autowired
	private WeiboService weiboService;
	
	@RequestMapping("/publish")
	@ResponseBody
	public BaseResponse<Weibo> publishWeibo(Weibo weibo,HttpSession session){
		User user = (User)session.getAttribute("user");
		weibo.setUserHeadimg(user.getHeadimg());
		weibo.setUserNickname(user.getNickname());
		weibo.setUserUsername(user.getUsername());
		return new BaseResponse<>(true,"发布成功",weiboService.publishWeibo(weibo));
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public ResponsePageVo listWeibo(HttpServletRequest request,WeiboCriteria criteria){
		
		String loginUUID = this.getLogin(request).getUuid();
		
		PaginatedList<WeiboVo> paginatedList = weiboService.listWeibo(criteria,loginUUID);
		Pagination pagination = paginatedList.getPagination();
		List<WeiboVo> result = paginatedList.getResult();
		ResponsePageVo response = new ResponsePageVo();
		response.setRows(result);
		response.setPage(pagination.getPage());
		response.setTotal(pagination.getTotal());
		response.setPageCount(pagination.getTotalPage());
		response.setPageSize(pagination.getPagesize());
		return response;
	}
	
	@RequestMapping("/like")
	@ResponseBody
	public BaseResponse<String> like(HttpServletRequest request,String operate,String weiboUuid){
		BaseResponse<String> res = new BaseResponse<>();
		
		String uuid = this.getLogin(request).getUuid();
		Like lik = new Like();
		lik.setLikedUser(uuid);
		lik.setLikedWeibo(weiboUuid);
		
		try {
			if("like".equals(operate)) {
				weiboService.likeWeibo(lik);
			}else if("unLike".equals(operate)) {
				weiboService.cancelLikeWeibo(lik);
			}else {
				throw new Exception("未知的操作");
			}
			res.setSuccess(true);
		}catch(Exception e) {
			res.setMessage(e.getMessage());
			res.setSuccess(false);
			LOGGER.error(e.getMessage());
		}
		return res;
	}
}
