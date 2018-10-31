package com.lifu.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lifu.dao.StudentDao;
import com.lifu.entity.PageBean;
import com.lifu.entity.Student;
import com.lifu.util.DbUtil;
import com.lifu.util.JsonUtil;
import com.lifu.util.ResponseUtil;
import com.lifu.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet {
	DbUtil dbUtil=new DbUtil();
	StudentDao gd=new StudentDao();
	
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
		String stuNo=req.getParameter("s_stuNo");
		String stuName=req.getParameter("s_stuName");
		String birthday=req.getParameter("s_birthday");
		String sex=req.getParameter("s_sex");
		String gradeId=req.getParameter("s_gradeId");
		Student student=new Student();
		if(stuNo!=null){
			student.setStuNo(stuNo);
			student.setStuName(stuName);
			student.setSex(sex);
			if(StringUtil.isNotEmpty(gradeId)){
				student.setGradeId(Integer.parseInt(gradeId));
			}
		}
		
		String page=req.getParameter("page");
		String rows=req.getParameter("rows");
		System.out.println("page--"+page);
		System.out.println("rows--"+rows);
		PageBean pagebean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject obj=new JSONObject();
			JSONArray array=null;
			array=JsonUtil.formatRsToJsonArray(gd.studentList(con,pagebean,student));
			int total=gd.studentCount(con,student);
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
