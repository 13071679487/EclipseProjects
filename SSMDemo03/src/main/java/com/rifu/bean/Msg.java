package com.rifu.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回信息类
 * @author Lifu
 *
 */
public class Msg {
	//状态码	100-success 200-fail
	private int code;
	//提示信息
	private String msg;
	//用户要返回给流浪器的数据
	private Map<String ,Object> extend=new HashMap<String ,Object>();
	
	public static Msg success(){
		Msg msg=new Msg();
		msg.setCode(100);
		msg.setMsg("成功");
		return msg;
	}
	
	public static Msg fail(){
		Msg msg=new Msg();
		msg.setCode(200);
		msg.setMsg("失败");
		return msg;
	}
	
	public Msg add(String key ,Object o){
		this.getExtend().put(key, o);
		return this;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
