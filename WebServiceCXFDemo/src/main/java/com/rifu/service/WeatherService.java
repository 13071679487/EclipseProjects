package com.rifu.service;

import javax.jws.WebService;

@WebService
public interface WeatherService {
	public String getWeatherByCity(String cityname);
}
