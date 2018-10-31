package com.rifu.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ½ûÓÃ»º´æµÄ¹ýÂËÆ÷
 * @author Lifu
 *
 */
@WebFilter(filterName="banCacheFilter",urlPatterns="/cache/*",dispatcherTypes={DispatcherType.REQUEST})
public class BanCacheFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Ban the cache Filter begin work...");
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		chain.doFilter(request,response);
	}

}
