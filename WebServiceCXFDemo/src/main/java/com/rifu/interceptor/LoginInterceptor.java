package com.rifu.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LoginInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	public LoginInterceptor() {
		super(Phase.PRE_INVOKE);	//在调用接口方法之间进行调用这个拦截器的方法
	}

	public void handleMessage(SoapMessage message) throws Fault {
		List<Header> headers = message.getHeaders();
		if(headers==null||headers.size()==0){
			throw new Fault(new IllegalArgumentException("This is a empty headers"));
		}
		Header header = headers.get(0);
		Element ele = (Element) header.getObject();
		NodeList uList = ele.getElementsByTagName("username");
		NodeList pList = ele.getElementsByTagName("password");
		if(uList.getLength()!=1){
			throw new Fault(new IllegalArgumentException("This is a error username"));
		}
		if(pList.getLength()!=1){
			throw new Fault(new IllegalArgumentException("This is a error password"));
		}
	}

}
