package com.lifu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lifu.model.PageBean;

public class StudentDao {
	public ResultSet studentList(Connection con,PageBean pg)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_studnet s,t_grade g where ");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

}
