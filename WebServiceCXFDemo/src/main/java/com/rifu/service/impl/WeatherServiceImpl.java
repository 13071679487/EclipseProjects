package com.rifu.service.impl;

import javax.jws.WebService;

import com.rifu.service.WeatherService;

@WebService
public class WeatherServiceImpl implements WeatherService{

	public String getWeatherByCity(String cityname) {
		// TODO Auto-generated method stub
		return "weather£º"+cityname;
	}

}
