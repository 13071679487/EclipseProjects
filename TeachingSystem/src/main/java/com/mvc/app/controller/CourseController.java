package com.mvc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mvc.app.model.Course;
import com.mvc.app.model.Msg;
import com.mvc.app.model.Student;
import com.mvc.app.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//id查询course
	@RequestMapping("/getCourseById/{id}")
	@ResponseBody
	public Msg getCourseById(@PathVariable("id")String courseid){
		
		Course course=courseService.selectById(courseid);
		return Msg.success().add("course", course);
	}
	
	//查询所有course
	@RequestMapping("/getCourses")
	@ResponseBody
	public Msg getCourses(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "size", defaultValue = "8") Integer size){
	
		PageHelper.startPage(pn, size);
		List<Course> courses=courseService.selectCouses(null);
		PageInfo page=new PageInfo(courses,5);
		return Msg.success().add("pageInfo", page);
	}
	
	//id删除course
	@RequestMapping("/deleteCourseById/{id}")
	@ResponseBody
	public Msg deleteById(@PathVariable("id")String courseid){
		
		courseService.deleteById(courseid);
		return Msg.success();
	}
	
	//修改course
	@RequestMapping("/updateCourse")
	@ResponseBody
	public Msg updateCourse(Course course){
		
		courseService.updateCourse(course);
		return Msg.success();
	}
	//添加course
	@RequestMapping("/saveCourse")
	@ResponseBody
	public Msg saveCourse(@RequestParam("course")Course course){
		
		courseService.saveCourse(course);
		return Msg.success();
	}
}
