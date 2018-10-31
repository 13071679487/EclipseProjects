package com.mvc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.dao.MajorMapper;
import com.mvc.app.model.Major;
import com.mvc.app.model.MajorExample;
import com.mvc.app.model.MajorKey;

@Service
public class MajorService {

	@Autowired
	private MajorMapper majorMapper;
	
	//根据学号和课程号查
	public Major selectByPrimarykey(MajorKey key){
		return majorMapper.selectByPrimaryKey(key);
	}
	
	/*//根据courseid查询选课及成绩
	public Major selectById(String mcourseid){
		
		return majorMapper.selectByMcourseid(mcourseid);
	}*/
	
	//查询选课及成绩
	public List<Major> selectByEample(MajorExample example){
		
	    return majorMapper.selectByExample(example);
	}
	
	//=======================简单维护====================
	//删除选课及成绩信息
	public void deleteByMajorKey(MajorKey key){
		
		majorMapper.deleteByPrimaryKey(key);
	}
	
	//修改选课及成绩信息
	public void updateMajor(Major major){
		majorMapper.updateByPrimaryKeySelective(major);
	}
	//添加保存选课及成绩信息
	public void saveMajor(Major major){
		majorMapper.insertSelective(major);
	}
}
