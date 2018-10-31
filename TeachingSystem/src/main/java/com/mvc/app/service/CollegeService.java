package com.mvc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.dao.CollegeMapper;
import com.mvc.app.model.College;
import com.mvc.app.model.CollegeExample;
import com.mvc.app.model.Student;

@Service
public class CollegeService {

	@Autowired
	private CollegeMapper collegeMapper;
	
	//id查询院系
	public College selectById(String colid){
		
		return collegeMapper.selectByPrimaryKey(colid);
	}
	
	//查询所有院系
	public List<College> selectColleges(CollegeExample example){
		
		return collegeMapper.selectByExample(example);
	}
	
	//id删除院系
	public void deleteById(String colid){
		
		collegeMapper.deleteByPrimaryKey(colid);
	}
	
	//修改院系信息
	public void updateCollege(College college){
		
		collegeMapper.updateByPrimaryKeySelective(college);
	}
	//添加院系信息
	public void saveCollege(College college){
		
		collegeMapper.insertSelective(college);
	}
	
}
