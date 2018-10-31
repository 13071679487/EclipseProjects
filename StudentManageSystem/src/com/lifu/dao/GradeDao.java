package com.lifu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lifu.entity.Grade;
import com.lifu.entity.PageBean;
import com.lifu.util.StringUtil;

public class GradeDao {
	/**
	 * 返回班级列表信息
	 * 
	 * @param con
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public ResultSet gradeList(Connection con, PageBean page, Grade grade) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_grade");
		if (grade != null && StringUtil.isNotEmpty(grade.getGradeName())) {
			sb.append(" and gradeName like '%" + grade.getGradeName() + "%'");
		}
		if (page != null) {
			sb.append(" limit " + page.getStart() + "," + page.getRows());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	public int gradeCount(Connection con, Grade grade) throws Exception {
		StringBuffer sql = new StringBuffer("select count(*) as total from t_grade");
		if (StringUtil.isNotEmpty(grade.getGradeName())) {
			sql.append(" and gradeName like '%" + grade.getGradeName() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}

	public int gradeDelete(Connection con, String delIds) throws Exception {
		String sql = "delete from t_grade where id in (" + delIds + ")";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}

	public int gradeAdd(Connection con, Grade grade) throws Exception {
		String sql = "insert into t_grade values (null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, grade.getGradeName());
		pstmt.setString(2, grade.getGradeDesc());
		return pstmt.executeUpdate();
	}

	public int gradeUpdate(Connection con, Grade grade) throws Exception {
		String sql = "update t_grade set gradeName=?,gradeDesc=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, grade.getGradeName());
		pstmt.setString(2, grade.getGradeDesc());
		pstmt.setInt(3, grade.getId());
		return pstmt.executeUpdate();
	}
}
