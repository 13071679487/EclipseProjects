package com.lifu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lifu.entity.PageBean;
import com.lifu.entity.Student;
import com.lifu.util.DateUtil;
import com.lifu.util.StringUtil;

public class StudentDao {
	
	/**
	 * 获取到学生列表信息
	 * @param con
	 * @param pb
	 * @return
	 * @throws Exception
	 */
	public ResultSet studentList(Connection con, PageBean pb,Student student) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_student s,t_grade g where s.gradeId=g.id");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s.stuNo='"+student.getStuNo()+"'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName like '%"+student.getStuName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and s.sex='"+student.getSex()+"'");
		}
//		if(StringUtil.isNotEmpty(student.getBirthday().toString())){
//			sb.append(" and TO_DAYS(s.birthday)>=TO_DAYS('"+student.getBirthday().toString()+"')");
//		}
		if(student.getGradeId()!=-1){
			sb.append(" and s.gradeId='"+student.getGradeId()+"'");
		}
		if (pb != null) {
			sb.append(" limit " + pb.getStart() + "," + pb.getRows());
		}
		System.out.println(sb.toString());
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	/**
	 * 获取学生数量
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public int studentCount(Connection con,Student student) throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from t_student s,t_grade g where s.gradeId=g.id");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s.stuNo='"+student.getStuNo()+"'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName like '%"+student.getStuName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and s.sex='"+student.getSex()+"'");
		}
//		if(StringUtil.isNotEmpty(student.getBirthday().toString())){
//			sb.append(" and TO_DAYS(s.birthday)>=TO_DAYS('"+student.getBirthday().toString()+"')");
//		}
		if(student.getGradeId()!=-1){
			sb.append(" and s.gradeId='"+student.getGradeId()+"'");
		}
		System.out.println(sb.toString());
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		}
		return 0;
	}
	
	public int studentDelete(Connection con,String stuIds)throws Exception{
		String sql="delete from t_student where stuId in("+stuIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int studentAdd(Connection con,Student student) throws Exception{
		String sql="insert into t_student values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNo());
		pstmt.setString(2, student.getStuName());
		pstmt.setString(3, student.getSex());
		pstmt.setString(4, DateUtil.formatDate(student.getBirthday(), "yyyy-MM-dd"));
		pstmt.setInt(5, student.getGradeId());
		pstmt.setString(6, student.getEmail());
		pstmt.setString(7, student.getStuDesc());
		return pstmt.executeUpdate();
	}
	
	public int studentModify(Connection con,Student student) throws Exception{
		String sql="update t_student set stuNo=?,stuName=?,sex=?,birthday=?,gradeId=?,email=?,stuDesc=? where stuId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNo());
		pstmt.setString(2, student.getStuName());
		pstmt.setString(3, student.getSex());
		pstmt.setString(4, DateUtil.formatDate(student.getBirthday(), "yyyy-MM-dd"));
		pstmt.setInt(5, student.getGradeId());
		pstmt.setString(6, student.getEmail());
		pstmt.setString(7, student.getStuDesc());
		pstmt.setInt(8, student.getId());
		return pstmt.executeUpdate();
	}
}
