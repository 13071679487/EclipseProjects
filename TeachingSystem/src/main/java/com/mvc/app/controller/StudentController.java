package com.mvc.app.controller;

import java.util.List;
import java.util.Map;

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
import com.mvc.app.model.StudentExample;
import com.mvc.app.model.StudentExample.Criteria;
import com.mvc.app.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/getStudentById/{id}")
	@ResponseBody
	//根据id查询学生
     public Msg getStudentById(@PathVariable("id")String stuid){
		System.out.println("stuid:"+stuid);
		Student student=studentService.selectById(stuid);
		return Msg.success().add("student", student);
	}
	//根据学生姓名查询
	@RequestMapping("/getStudentBySname")
	@ResponseBody
	public Msg getStudentBySname(@RequestParam("sname")String sname){
		StudentExample example=new StudentExample();
		Criteria criteria=example.createCriteria();
		criteria.andSnameEqualTo(sname);
		List<Student> student=studentService.selectByExample(example);
		return Msg.success().add("student",student);
	}
	
	//查询学生所有信息(分页查询)
	@RequestMapping("/getStudents")
	@ResponseBody
	public Msg getStudents(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "size", defaultValue = "8") Integer size){
		
		// 在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pn, size);
		List<Student> students=studentService.selectAll(null);
		PageInfo page=new PageInfo(students,5);
		return Msg.success().add("pageInfo",page);
		
	}
	
	//根据id删除学生
	@RequestMapping("/deleteStudentById/{id}")
	@ResponseBody
	public Msg deleteStuent(@PathVariable("id")String stuid){
		
		studentService.deleteById(stuid);
		return Msg.success();
		
	}
	//更新学生
	@RequestMapping("/updateStudent/{id}")
	@ResponseBody
	public Msg updateStudent(@PathVariable("id")String id, Student student){	
		student.setStuid(id);
		studentService.updateStu(student);
		System.out.println(student.getPhone());
		return Msg.success();
	}
	//添加学生
	@RequestMapping("/saveStudent")
	@ResponseBody
	public Msg saveStudent(Student student){
		studentService.saveStudent(student);
		return Msg.success();
	}
	//性别统计课程的平均成绩
	@RequestMapping("/selectAVGBySex")
	@ResponseBody
/*	public Msg getBySex(@RequestParam("sex")String sex){
		StudentExample example=new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andSexEqualTo(sex);
		List<Student> selectByExample = studentService.selectAll(example);
		return Msg.success().add("students", selectByExample);
	}*/
	public Msg selectAVGBySex(){
		List<Map<String,Object>> list=(List<Map<String, Object>>) studentService.selectAVGBySex();
	    return Msg.success().add("mapSexAvg", list);
	}
	
	//生源地人数统计
	@RequestMapping("/selectByAddress")
	@ResponseBody
	/*public Msg selectByAddress(@RequestParam("address")String address){
		StudentExample example=new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andAddressEqualTo(address);
		List<Student> students=studentService.selectByExample(example);
		return Msg.success().add("students", students);
	}*/
	public Msg selectByAddress(){
		
		List<Map<String,Object>> list=(List<Map<String, Object>>) studentService.selectGroupByAddress();
		System.out.println(list.get(0).get("count"));
		return Msg.success().add("mapAddress",list );
	}
	
	//查询各院系不及格课程名单
	@RequestMapping("/selectFail")
	@ResponseBody
	public Msg selectFail(){
		List<Map<String,Object>> list=(List<Map<String, Object>>) studentService.selectFail();
		return Msg.success().add("mapFail", list);
	}
	//查询各院系各课程平均成绩
	@RequestMapping("/selectAVGByCol")
	@ResponseBody
	public Msg selectAVGByCol(){
		List<Map<String,Object>> list=(List<Map<String, Object>>) studentService.selectAVGByCol();
		return Msg.success().add("mapColAvg", list);
	}
	//查询各院系性别人数
	@RequestMapping("/selectCountBySex")
	@ResponseBody
	public Msg selectCountBySex(){
		
		List<Map<String,Object>> list=(List<Map<String, Object>>) studentService.selectCountBySex();
		return Msg.success().add("mapCountSex", list);
	}
}
