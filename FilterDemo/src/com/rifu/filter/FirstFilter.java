package com.rifu.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * �������صķ�ʽ
 * 1.REQUEST(get/post)Ĭ��
 * 2.FORWARD
 * 3.INCLUDE
 * 4.ERROR
 * 
 * ���ù��������������ط�ʽ��web.xml����
 * <dispatcher></dispatcher>
 * @author Lifu
 *
 */

@WebFilter(filterName="firstFilter",urlPatterns="/second.jsp",dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.ERROR})
public class FirstFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		//������൱�ڷ�������
		filterChain.doFilter(request, response);
	}

}
