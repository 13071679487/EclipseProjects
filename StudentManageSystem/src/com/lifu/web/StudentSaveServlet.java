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
import com.lifu.entity.Student;
import com.lifu.util.DateUtil;
import com.lifu.util.DbUtil;
import com.lifu.util.ResponseUtil;
import com.lifu.util.StringUtil;

import net.sf.json.JSONObject;

@WebServlet("/studentSave")
public class StudentSaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	StudentDao gd=new StudentDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stuNo=req.getParameter("stuNo");
		String stuName=req.getParameter("stuName");
		String sex=req.getParameter("sex");
		String birthday=req.getParameter("birthday");
		String gradeId=req.getParameter("gradeId");
		String email=req.getParameter("email");
		String stuDesc=req.getParameter("stuDesc");
		String id=req.getParameter("stuId");
		Student student=null;
		try {
			student = new Student( stuName,  stuNo,  sex,  DateUtil.formatString(birthday, "yyyy-MM-dd"),  Integer.parseInt(gradeId),  email,  stuDesc);
			if(StringUtil.isNotEmpty(id)){
				student.setId(Integer.parseInt(id));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		Connection con=null;
		try{
			
			con=dbUtil.getCon();
			JSONObject obj=new JSONObject();
			int saveNums=0;
			if(StringUtil.isNotEmpty(id)){
				saveNums=gd.studentModify(con, student);
			}else{
				saveNums=gd.studentAdd(con, student);
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
