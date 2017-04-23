package com.ymzhu.session;

import javax.servlet.http.HttpServletRequest;

import com.ymzhu.domain.User;

public class SessionUtils {
	public static final String SESSION_USER = "BCS__SESSION__USER__KEY";

	public static User getUserFromRequest(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(SESSION_USER);
		if (user != null) {
			return user;
		}
		return null;
	}
}
