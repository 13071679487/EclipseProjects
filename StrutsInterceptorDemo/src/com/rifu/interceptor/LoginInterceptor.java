package com.rifu.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceptor  ����");
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceptor  ��ʼ��");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��Actionִ��֮ǰ");
		String result=invocation.invoke();
		System.out.println("result:"+result);
		System.out.println("��Actionִ��֮��");
		return result;
	}

}
