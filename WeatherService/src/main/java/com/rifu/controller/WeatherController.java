package com.rifu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rifu.bean.Weather;
import com.rifu.bean.WeatherExample;
import com.rifu.service.BaseService;

@Controller
public class WeatherController {
	@Autowired
	private BaseService<Weather,WeatherExample> weatherService;
	
//		String remoteHost = req.getRemoteHost();
//		String remoteAddr = req.getRemoteAddr();
//		System.out.println("remoteHost"+remoteHost);
//		System.out.println("remoteAddr"+remoteAddr);
	//String addressByIP = getAddressByIP(req);
	//System.out.println("addressByIP"+addressByIP);
	
	@RequestMapping("/weather")
	@ResponseBody
	public String getWeatherByCityName(HttpServletRequest req){
		weatherService.deleteObjectByPrimarykey(1);
		return "weather";
	}
	

	
}
