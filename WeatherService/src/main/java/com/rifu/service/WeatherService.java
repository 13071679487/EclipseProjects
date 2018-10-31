package com.rifu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rifu.bean.Weather;
import com.rifu.bean.WeatherExample;
import com.rifu.dao.WeatherMapper;

@Service
public class WeatherService implements BaseService<Weather, WeatherExample>{

	@Autowired
	private WeatherMapper weatherMapper;
	
	public Weather getObjectByPrimarykey(Object id) {
		return null;
	}

	public int insertObject(Weather m) {
		return 0;
	}

	public int updateObject(Weather m) {
		return 0;
	}

	public int deleteObjectByPrimarykey(Object id) {
		return weatherMapper.deleteByPrimaryKey(Integer.parseInt(id.toString()));
	}

	public List<Weather> getObjectsByExample(WeatherExample e) {
		return null;
	}

}
