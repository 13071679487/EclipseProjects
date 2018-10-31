package com.rifu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.rifu.dao.StudentDao;
import com.rifu.model.Student;

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {

	@Override
	public int addStudent(Student stu) {
		String sql="insert into t_student values(null,?,?)";
		Object []params=new Object[]{stu.getName(),stu.getAge()};
		return this.getJdbcTemplate().update(sql,params);
	}

	@Override
	public int updateStudent(Student stu) {
		String sql="update t_student set name=?,age=? where id=?";
		Object []params=new Object[]{stu.getName(),stu.getAge(),stu.getId()};
		return this.getJdbcTemplate().update(sql,params);
	}

	@Override
	public int deleteStudent(int id) {
		String sql="delete from t_student where id=?";
		Object []params=new Object[]{id};
		return this.getJdbcTemplate().update(sql,params);
	}

	@Override
	public List<Student> findStudents() {
		String sql="select * from t_student";
		final List<Student> students=new ArrayList<>();
		this.getJdbcTemplate().query(sql, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Student student=new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				students.add(student);
			}
			
		});
		return students;
	}

}
