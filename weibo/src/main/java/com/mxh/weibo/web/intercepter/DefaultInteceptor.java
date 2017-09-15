package com.mxh.weibo.web.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DefaultInteceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String[] uris = request.getRequestURI().replace(request.getContextPath(), "").split("/");
		if (uris.length > 1) {
			request.setAttribute("module1", uris[1]);
		}
		if (uris.length > 2) {
			request.setAttribute("nav1", uris[2]);
		}
		String ctx = request.getContextPath();
		String res = ctx;
		request.setAttribute("ctx", ctx);

		request.setAttribute("res", res);
		request.setAttribute("js", res + "/js");
		request.setAttribute("css", res + "/css");
		request.setAttribute("images", res + "/images");
		// request.setAttribute("Dict",
		// FreemarkerUtils.getStaticTemplateModel(DictCache.class));

		response.setHeader("Pragma", "No-cache");

		// request.setAttribute("remoteIp", getRemoteIP(request));
		return true;
	}
}
