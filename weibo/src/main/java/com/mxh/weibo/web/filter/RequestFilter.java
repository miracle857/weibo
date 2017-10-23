package com.mxh.weibo.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;


/**
 *  过滤请求参数中的值----对其进行  *.trim() 方法。
 */
public class RequestFilter extends OncePerRequestFilter {

	public String filter(HttpServletRequest request, String input) {
		if (input != null) {
			return input.trim();
		}
		return input;
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		chain.doFilter(new HttpServletRequestWrapper(request) {
			@Override
			public String getParameter(String name) {
				String value = super.getParameter(name);
				return filter(this, value);
			}

			@Override
			public String[] getParameterValues(String name) {
				String[] values = super.getParameterValues(name);
				if (values == null) {
					return null;
				}
				for (int i = 0; i < values.length; i++) {
					values[i] = filter(this, values[i]);
				}
				return values;
			}
		}, response);
	}
}