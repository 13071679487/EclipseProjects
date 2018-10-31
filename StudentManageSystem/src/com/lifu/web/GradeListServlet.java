package com.lifu.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lifu.dao.GradeDao;
import com.lifu.entity.Grade;
import com.lifu.entity.PageBean;
import com.lifu.util.DbUtil;
import com.lifu.util.JsonUtil;
import com.lifu.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/gradeList")
public class GradeListServlet extends HttpServlet {
	DbUtil dbUtil=new DbUtil();
	GradeDao gd=new GradeDao();
	
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
		resp.setContentType("text/html;charset=utf-8");
		String page=req.getParameter("page");
		String rows=req.getParameter("rows");
		String gradeName=req.getParameter("gradeName");
		if(gradeName==null){
			gradeName="";
		}
		Grade grade=new Grade();
		grade.setGradeName(gradeName);
		System.out.println("page--"+page);
		System.out.println("rows--"+rows);
		PageBean pagebean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			
			JSONObject obj=new JSONObject();
			JSONArray array=JsonUtil.formatRsToJsonArray(gd.gradeList(con,pagebean,grade));
			int total=gd.gradeCount(con,grade);
			obj.put("rows", array);
			obj.put("total", total);
			System.out.println(obj.toString());
			ResponseUtil.write(resp, obj);
		}catch(Exception e){
			
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
