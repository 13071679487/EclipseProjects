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
import com.lifu.util.DbUtil;
import com.lifu.util.ResponseUtil;
import com.lifu.util.StringUtil;

import net.sf.json.JSONObject;

@WebServlet("/gradeSave")
public class GradeSaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	GradeDao gd=new GradeDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gradeName=req.getParameter("gradeName");
		String gradeDesc=req.getParameter("gradeDesc");
		String id=req.getParameter("id");
		System.out.println(gradeName+"--------"+gradeDesc);
		Grade grade=new Grade(gradeName,gradeDesc);
		if(StringUtil.isNotEmpty(id)){
			grade.setId(Integer.parseInt(id));
		}
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject obj=new JSONObject();
			int saveNums=0;
			if(StringUtil.isNotEmpty(id)){
				saveNums=gd.gradeUpdate(con, grade);
			}else{
				saveNums=gd.gradeAdd(con, grade);
			}
			if(saveNums>0){
				obj.put("success", "true");
			}else{
				obj.put("errorMsg", "ÃÌº” ß∞‹");
			}
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
