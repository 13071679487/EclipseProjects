package com.rifu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rifu.entity.User;
import com.rifu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest req){
		User result=userService.login(user);
		if(result==null){
			req.setAttribute("user", user);
			req.setAttribute("errorMsg", "用户名或者密码错误");
			return "index";
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("currentUser", result);
			return "redirect:/success.jsp";
		}
	}
}
