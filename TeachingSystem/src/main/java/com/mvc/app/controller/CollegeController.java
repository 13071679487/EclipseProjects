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
import com.mvc.app.model.College;
import com.mvc.app.model.Msg;
import com.mvc.app.model.Student;
import com.mvc.app.service.CollegeService;

@Controller
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	//id查询college
	@RequestMapping("/getCollegeById/{id}")
	@ResponseBody
	public Msg getCollegeById(@PathVariable("id")String colid){
		
		College college=collegeService.selectById(colid);
		return Msg.success().add("college", college);
	}
	//查询所有院系(分页)
	@RequestMapping("/getColleges")
	@ResponseBody
	public Msg getColleges(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "size", defaultValue = "8") Integer size){
		
		PageHelper.startPage(pn, size);
		List<College> colleges=collegeService.selectColleges(null);
		PageInfo page=new PageInfo(colleges,5);
		return Msg.success().add("pageInfo",page);
		
	}
	//id删除院系
	@RequestMapping("/deleteCollegeById/{id}")
	@ResponseBody
	public Msg deleteCollegeById(@PathVariable("id")String colid){
		
		collegeService.deleteById(colid);
		return Msg.success();
	}
	//修改院系
	@RequestMapping("/updateCollege/{id}")
	@ResponseBody
	public Msg updateCollege(@PathVariable("id")String colid,College college){
		
		college.setColid(colid);
		collegeService.updateCollege(college);
		return Msg.success();
	}
	//添加院系
	@RequestMapping("/saveCollege")
	@ResponseBody
	public Msg saveCollege(College college){
		
		collegeService.saveCollege(college);
		return Msg.success();
	}
}
