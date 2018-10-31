package com.rifu.util;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.rifu.bean.Weather;

/**
 * 解析网站http://i.tianqi.com/index.php
 * 传递参数：?c=code&id=12&icon=1&num=5
 * @author Lifu
 *
 */
public class HtmlParseUtil {
	static String weatherUrl="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5";
	static String addressUrl="http://ip.taobao.com/service/getIpInfo.php?ip=";
	
	
	public static Weather getWeatherByCityPY(String py) throws Exception{
		StringBuffer sb=new StringBuffer();
		sb.append(weatherUrl);
		//sb.append("&py="+py);
//		Document doc = Jsoup.parse(new URL(sb.toString()), 10000);
		Document doc = Jsoup.connect(weatherUrl).userAgent("Mozilla").cookie("auth", "token").timeout(10000).get();
		String cityname=doc.getElementsByClass("wtname").text();
		System.out.println(cityname);
		return null;
	}
	
	public String getAddressByIP(String ip) throws Exception{
		StringBuffer sb=new StringBuffer();
		sb.append(addressUrl);
		sb.append(ip);
		//Document doc = Jsoup.parse(new URL(sb.toString()), 10000);
		return null;
	}
	
	public static String getIPByRequest(HttpServletRequest req){
		String ip = req.getHeader("x-forwarded-for");  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		    ip = req.getHeader("Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		    ip = req.getHeader("WL-Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		   ip = req.getHeader("HTTP_CLIENT_IP");  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		   ip = req.getHeader("HTTP_X_FORWARDED_FOR");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		      ip = req.getRemoteAddr();  
		 }  
	   return ip;  
	}
	
	public static void main(String[] args) {
		try {
			getWeatherByCityPY("jiangmen");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
