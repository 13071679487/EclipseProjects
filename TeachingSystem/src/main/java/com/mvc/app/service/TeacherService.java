package com.mvc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.dao.CourseMapper;
import com.mvc.app.dao.TeacherMapper;
import com.mvc.app.model.Course;
import com.mvc.app.model.Lecture;
import com.mvc.app.model.Student;
import com.mvc.app.model.Teacher;
import com.mvc.app.model.TeacherExample;

@Service
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	//=======================简单查询=======================
	//id查询教师情况
	public Teacher selectById(String tid){
		
		return teacherMapper.selectByPrimaryKey(tid);
		
	}
    //根据条件查询教师
	public List<Teacher> selectByExample(TeacherExample example){
		
		return teacherMapper.selectByExample(example);
	}
	
	//=======================连表查询=======================
	//查询教师的所有情况
	public List<Teacher> selectAll(TeacherExample example){
		
	   List<Teacher> teachers=teacherMapper.selectByExampleWithLectureCourse(example);
	   return teachers;
	}
	
	//=======================简单维护=======================
	//id删除教师
	public void deleteById(String tid){
		
		teacherMapper.deleteByPrimaryKey(tid);
	}
	
	//更新教师
	public void updateTeacher(Teacher teacher){
		teacherMapper.updateByPrimaryKeySelective(teacher);
	}
	
	//保存教师
	public void saveTeacher(Teacher teacher){
		teacherMapper.insertSelective(teacher);
	}
	
}
