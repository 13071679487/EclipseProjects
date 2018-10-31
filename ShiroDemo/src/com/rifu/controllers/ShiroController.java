package com.rifu.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rifu.services.ShiroService;

@Controller
@RequestMapping("/shiro")
public class ShiroController {
	@Autowired
	private ShiroService shiroService;
	
	public static final String SUCCESS="success";
	public static final String ERROR="error";
	
	@RequestMapping("/testShiroAnnotation")
	public String testShiroAnnotation(){
		shiroService.testMethod();
		return "redirect:/list.jsp";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password){
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			System.out.println("controllerToken:"+token);
			token.setRememberMe(true);
			try{
				currentUser.login(token);
			}catch(AuthenticationException ae){
				System.out.println("LOGIN FAIL:"+ae);
			}
		}
		else{
			System.out.println(currentUser);
		}
		return "redirect:/list.jsp";
	}
}
