package com.ymzhu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymzhu.domain.User;
import com.ymzhu.service.UserService;
import com.ymzhu.session.SessionUtils;

@Controller
@RequestMapping({ "/", "/web" })
public class LoginController extends AbstractBaseController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public void homePage(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.sendRedirect(request.getContextPath() + "/web/showLogin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/doLogin")
	@ResponseBody
	public String doLogin(@ModelAttribute() User user, HttpServletRequest request, BindingResult result) {
		User u = userService.selectUserByUsername(user.getUsername());
		if (u == null) {
			return getLoginJSONResult(-1).toJSONString();
		}
		if (!user.getUserpwd().equals(u.getUserpwd())) {
			return getLoginJSONResult(0).toJSONString();
		}
		request.getSession().setAttribute(SessionUtils.SESSION_USER, user);
		return getLoginJSONResult(1).toJSONString();
	}

	@RequestMapping("/logout")
	public void logout(HttpServletResponse response, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute(SessionUtils.SESSION_USER);
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/web/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/showLogin")
	public String showLogin(HttpServletRequest request, Model model) throws Exception{
		return AccessPrefix.BCS + "/login";
	}
}
