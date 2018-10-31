package com.mvc.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.app.model.Msg;
import com.mvc.app.model.Role;
import com.mvc.app.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	//注册，添加用户
	@RequestMapping("/addRole")
	@ResponseBody
	public Msg addRole(Role role,HttpServletRequest req){
		try{
			roleService.addRole(role);
			req.getSession().setAttribute("currentUser", role);
			System.out.println("注册成功");
			return Msg.success().add("href", "login.jsp");
		}catch(Exception e){
			System.out.println("注册失败");
			return Msg.fail().add("href", "register.jsp");
		}
	}
	
	//登录验证
	@RequestMapping("/checkLogin")
	@ResponseBody
	public Msg checkLogin(@RequestParam("rname")String rname,
			              @RequestParam("password")String password,
			              @RequestParam("code")String code,
			              HttpServletRequest request,HttpSession session){
		if(!(code.equalsIgnoreCase(session.getAttribute("code").toString()))){
			System.out.println("核对结果："+!(code.equalsIgnoreCase(session.getAttribute("code").toString())));
			return Msg.fail().add("errorMsg","验证码错误！");
		}else{
			if(roleService.checkLogin(rname, password)){
				session.setAttribute("currentUser", roleService.getRoleByExample(rname, password));
				return Msg.success().add("href", "home.jsp");
			}else{
				return Msg.fail().add("errorMsg","用户名或密码错误！");
			}
	    }
	}
	
	//注销登录
	@RequestMapping("/outLogin")
	@ResponseBody
	public Msg outLogin(HttpSession session){
		
		session.invalidate();
		return Msg.success();
	} 
}
