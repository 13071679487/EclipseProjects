package com.rifu.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rifu.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("登录验证");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		User currentUser = new User(userName, password);
		Cookie cookie = new Cookie("user", userName + "-" + password);
		cookie.setMaxAge(1 * 60 * 60 * 24 * 7);
		resp.addCookie(cookie);
		HttpSession session = req.getSession();
		session.setAttribute("currentUser", currentUser);
		return "redirect:/main.jsp";
	}

	/**
	 * 直接对request的使用
	 * 
	 * @param req
	 * @return
	 */
	public String login2(HttpServletRequest req) {
		return "redirect:/main.jsp";
	}

	public String login3(HttpSession session) {
		return "redirect:/main.jsp";
	}

	/**
	 * @ResponseBody 这个注解自动将返回的对象转化为json对象
	 * @return
	 */
	@RequestMapping("/ajax")
	public @ResponseBody User ajax() {
		User user = new User("rifu", "123456");
		return user;
	}
}
