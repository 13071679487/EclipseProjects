package com.mvc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.dao.CourseMapper;
import com.mvc.app.model.Course;
import com.mvc.app.model.CourseExample;
import com.mvc.app.model.Student;

@Service
public class CourseService {
	
	@Autowired
	private CourseMapper courseMapper;
	
	//id查询course
	public Course selectById(String courseid){
		
		return courseMapper.selectByPrimaryKey(courseid);
	}
	
	//根据条件查询所有课程信息
	public List<Course> selectCouses(CourseExample example){
		
		return courseMapper.selectByExample(example);
	}
	
	//id删除课程信息
	public void deleteById(String courseid){
		
		courseMapper.deleteByPrimaryKey(courseid);
	}
	
	//修改课程信息
	public void updateCourse(Course course){
		
	   courseMapper.updateByPrimaryKeySelective(course);
	}
	//添加课程
	public void saveCourse(Course course){
		
		courseMapper.insertSelective(course);
	}

}
