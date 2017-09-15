package com.mxh.weibo.web.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DefaultInteceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);


		// request.setAttribute("Dict",
		// FreemarkerUtils.getStaticTemplateModel(DictCache.class));

		response.setHeader("Pragma", "No-cache");

		// request.setAttribute("remoteIp", getRemoteIP(request));
		return true;
	}
}
