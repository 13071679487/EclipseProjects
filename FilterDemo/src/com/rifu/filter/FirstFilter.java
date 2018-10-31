package com.rifu.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 请求拦截的方式
 * 1.REQUEST(get/post)默认
 * 2.FORWARD
 * 3.INCLUDE
 * 4.ERROR
 * 
 * 配置过滤器的请求拦截方式在web.xml配置
 * <dispatcher></dispatcher>
 * @author Lifu
 *
 */

@WebFilter(filterName="firstFilter",urlPatterns="/second.jsp",dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.ERROR})
public class FirstFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		//这个就相当于放行请求
		filterChain.doFilter(request, response);
	}

}
