package com.mxh.weibo.web.intercepter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mxh.weibo.common.model.User;

public class DefaultInteceptor extends HandlerInterceptorAdapter {

	List<String> ignoreUrl;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ctx = request.getContextPath();
		request.setAttribute("ctx", ctx);

		// 获取URI后缀
		String requestUri = request.getServletPath();

		if (requestUri.equalsIgnoreCase("/"))
			return true;

		// 过滤不需要拦截的地址
		for (String string : ignoreUrl) {
			if (requestUri.startsWith(string)) {
				return true;
			}
		}
		

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("/user/main.do");
			return false;
		}
		// request.setAttribute("Dict",
		// FreemarkerUtils.getStaticTemplateModel(DictCache.class));

		// response.setHeader("Pragma", "No-cache");

		// request.setAttribute("remoteIp", getRemoteIP(request));
		return true;
	}

	public List<String> getIgnoreUrl() {
		return ignoreUrl;
	}

	public void setIgnoreUrl(List<String> ignoreUrl) {
		this.ignoreUrl = ignoreUrl;
	}
}
