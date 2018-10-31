package com.rifu.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="loginFilter",urlPatterns="/login/*")
public class LoginFilter extends HttpFilter{
	String userSessionKey;
	String rediretPage;
	List<String> uncheckedUrls=new ArrayList<>();
	@Override
	protected void init() {
		userSessionKey=getFilterConfig().getServletContext().getInitParameter("userSessionKey");
		System.out.println("userSessionKey:"+userSessionKey);
		rediretPage=getFilterConfig().getServletContext().getInitParameter("rediretPage");
		System.out.println("rediretPage: "+rediretPage);
		String [] uncheckeds=getFilterConfig().getServletContext().getInitParameter("uncheckedUrls").split(",");
		for(String url:uncheckeds){
			uncheckedUrls.add(url);
		}
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("begin filter");
		String servletPath=request.getServletPath();
		System.out.println("ÇëÇóµÄÂ·¾¶"+servletPath);
		if(uncheckedUrls.contains(servletPath)){
			System.out.println("begin jump");
			filterChain.doFilter(request, response);
			return;
		}
		
		String username=(String) request.getSession().getAttribute(userSessionKey);
		if(username==null||username.trim().equals("")){
			response.sendRedirect(request.getContextPath()+rediretPage);
			return;
		}
		filterChain.doFilter(request, response);
	}

}
