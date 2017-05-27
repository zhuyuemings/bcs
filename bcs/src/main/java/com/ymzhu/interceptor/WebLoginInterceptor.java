package com.ymzhu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ymzhu.domain.User;
import com.ymzhu.session.SessionUtils;

public class WebLoginInterceptor extends HandlerInterceptorAdapter {
	private static final String[] IGNORE_URL = { "/user/login" };

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		String url = request.getRequestURL().toString();
		for (String str : IGNORE_URL) {
			if (url.contains(str)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			User user = (User) request.getSession().getAttribute(SessionUtils.SESSION_USER);
			if (user != null) {
				flag = true;
			} else {
				response.sendRedirect(request.getContextPath() + "/user/login");
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
