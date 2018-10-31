package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import bean.City;
import dao.CityDao;
import util.ResultCodeUtil;
@WebServlet("/city")
public class CityServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter = resp.getWriter();
		CityDao cd=new CityDao();
		ArrayList<City> cities=cd.getCities();
		if(cities.size()==0){
			printWriter.write(ResultCodeUtil.FAIL+"");
		}
		else{
			JSONArray jsons=new JSONArray();
			for(int i=0;i<cities.size();i++){
				JSONObject json=(JSONObject) JSON.toJSON(cities.get(i));
				jsons.add(json);
			}
			printWriter.write(jsons.toString());
		}
		printWriter.flush();
	}
}
