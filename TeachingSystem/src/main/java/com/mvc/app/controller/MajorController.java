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
import com.mvc.app.model.Major;
import com.mvc.app.model.MajorKey;
import com.mvc.app.model.Msg;
import com.mvc.app.service.MajorService;

@Controller
public class MajorController {

	@Autowired
	private MajorService majorService;
	
	//根据mstuid,courseid查询major
	@RequestMapping("/getMajorById")
	@ResponseBody
	public Msg getMajorById(@RequestParam("id")String mstuid,@RequestParam("lid")String courseid){
		
		MajorKey key=new MajorKey();
		key.setMstuid(mstuid);
		key.setMcourseid(courseid);
		Major major=majorService.selectByPrimarykey(key);
		return Msg.success().add("major", major);
	}
	
	//查询所有选课及成绩信息
	@RequestMapping("/getMajors")
	@ResponseBody
	public Msg getMajors(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "size", defaultValue = "8") Integer size){
		
		PageHelper.startPage(pn, size);
		List<Major> majors=majorService.selectByEample(null);
		PageInfo page=new PageInfo(majors,5);
		return Msg.success().add("pageInfo",page);

	}
	//mstuid和mcourseid删除选课及成绩信息
	@RequestMapping("/deleteMajorById")
	@ResponseBody
	public Msg deleteMajor(@RequestParam("id")String mstuid,@RequestParam("lid")String mcourseid){
		
		MajorKey key=new MajorKey();
		key.setMstuid(mstuid);
		key.setMcourseid(mcourseid);
		majorService.deleteByMajorKey(key);
		return Msg.success();	
	}
	
	//修改选课及成绩信息
	@RequestMapping("/updateMajor/{id}")
	@ResponseBody
	public Msg updateMajor(@PathVariable("id")String idAndLid,Major major){
		String[] ids=idAndLid.split("-");
		major.setMstuid(ids[0]);
		major.setMcourseid(ids[1]);
		majorService.updateMajor(major);
		return Msg.success();	
	}
	
	//添加选课及成绩信息
	@RequestMapping("/saveMajor")
	@ResponseBody
	public Msg saveMajor(Major major){
		
		majorService.saveMajor(major);
		return Msg.success();
	}
	
}
