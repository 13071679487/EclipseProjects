package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBManager.DBManagerUtil;
import bean.City;
import util.C3P0Util;

public class CityDao {
	public CityDao(){}
	public ArrayList<City> getCities(){
		ArrayList<City> cities=new ArrayList<>();
		Connection conn=null;
		try {
			conn = C3P0Util.getConnection();
			String sql = "select * from city" ;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				City city=new City();
				city.setId(rs.getInt("id"));
				city.setIndex(rs.getString("city_index"));
				city.setCity_name(rs.getString("city_name"));
				cities.add(city);
			}
		} catch (Exception e) {
			C3P0Util.releaseConnection(conn);
			e.printStackTrace();
		}
		C3P0Util.releaseConnection(conn);
		return cities;
	}
}
