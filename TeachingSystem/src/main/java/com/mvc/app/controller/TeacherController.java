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
import com.mvc.app.model.Msg;
import com.mvc.app.model.Student;
import com.mvc.app.model.Teacher;
import com.mvc.app.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	//id查询教师
	@RequestMapping("/getTeacherById/{id}")
	@ResponseBody
	public Msg getTeacherById(@PathVariable("id")String tid){
		
		Teacher teacher=teacherService.selectById(tid);
		return Msg.success().add("teacher", teacher);
	}
	
	
	//查询教师信息(分页查询)
	@RequestMapping("/getTeachers")
	@ResponseBody
	public Msg getTeachers(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "size", defaultValue = "8") Integer size){				
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, size);
		List<Teacher> teachers=teacherService.selectByExample(null);
		PageInfo page=new PageInfo(teachers,5);
		return Msg.success().add("pageInfo",page);
	}
	
	//查询教师所有信息(连表，分页查询)
	@RequestMapping("/getTeachersAll")
	@ResponseBody
	public Msg getTeachersAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "size", defaultValue = "8") Integer size){
				
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, size);
		List<Teacher> teachers=teacherService.selectAll(null);
		PageInfo page=new PageInfo(teachers,5);
		return Msg.success().add("pageInfo",page);
	}
	
	//根据id删除教师
	@RequestMapping("/deleteTeacherById/{id}")
	@ResponseBody
	public Msg deleteTeacher(@PathVariable("id")String tid){
		teacherService.deleteById(tid);
		return Msg.success();
	}
	
	//更新教师
	@RequestMapping("/updateTeacher/{id}")
	@ResponseBody
	public Msg updateTeacher(@PathVariable("id")String id,Teacher teacher){	
		teacher.setTid(id);
		teacherService.updateTeacher(teacher);
		System.out.println(teacher.getTname());
		return Msg.success();
		
	}
	//添加教师
	@RequestMapping("/saveTeacher")
	@ResponseBody
	public Msg saveTeacher( Teacher teacher){
		
		teacherService.saveTeacher(teacher);
		return Msg.success();
	}
}
