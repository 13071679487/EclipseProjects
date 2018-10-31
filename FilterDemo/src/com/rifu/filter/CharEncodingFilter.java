package com.rifu.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="encodingFilter",urlPatterns="/*")
public class CharEncodingFilter extends HttpFilter{
	String encoding;
	
	@Override
	protected void init() {
		//��ȡweb.xml�����õı��뷽ʽ
		encoding=this.getFilterConfig().getServletContext().getInitParameter("encoding");
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(request, response);
	}

}
