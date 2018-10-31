package com.lifu.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lifu.dao.GradeDao;
import com.lifu.util.DbUtil;
import com.lifu.util.JsonUtil;
import com.lifu.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/gradeName")
public class GradeNameServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil = new DbUtil();
	GradeDao gradeDao = new GradeDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			JSONArray array=new JSONArray();
			JSONObject jsonobj=new JSONObject();
			jsonobj.put("id", "");
			jsonobj.put("gradeName", "«Î—°‘Ò∞‡º∂");
			array.add(jsonobj);
			array.addAll(JsonUtil.formatRsToJsonArray(gradeDao.gradeList(con, null, null)));
			ResponseUtil.write(resp, array);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
