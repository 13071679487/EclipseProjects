package com.mvc.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.dao.CourseMapper;
import com.mvc.app.dao.StudentMapper;
import com.mvc.app.model.Course;
import com.mvc.app.model.Major;
import com.mvc.app.model.Student;
import com.mvc.app.model.StudentExample;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CourseMapper courseMapper;
	
	//=======================简单查询=======================
	
	//根据学生代号查找
	public Student selectById(String stuid){
		return studentMapper.selectByPrimaryKey(stuid);
	}
	//根据条件查找
	public List<Student> selectByExample(StudentExample example){
		return studentMapper.selectByExample(example);
	}
	
    //=======================连表查询=======================
	
    //根据学号代号查询
    public Student selectByStuid(String stuid){
		return studentMapper.selectByPrimaryKeyWithCourseMajor(stuid);
	}
    //查询学生所有情况(course、major,college)
	public List<Student> selectAll(StudentExample example){
				List<Student> selectByExampleWithCourseMajor = studentMapper.selectByExampleWithCourseMajor(example);
				for(Student s:selectByExampleWithCourseMajor){
					List<Major> majors = s.getMajors();
					for(Major m:majors){
						String majorId=m.getMcourseid();
						Course course = courseMapper.selectByPrimaryKey(majorId);
						m.setCourse(course);
					}
				}
				return selectByExampleWithCourseMajor;
		
	}
	//======================统计查询=======================
	//生源地人数统计
	public List<Map<String, Object>> selectGroupByAddress(){
		return studentMapper.selectGroupByAddress();
	}
	//性别统计课程平均成绩
	public List<Map<String, Object>> selectAVGBySex(){
		return studentMapper.selectAVGBySex();
	}
	//各院系不及格课程名单
	public List<Map<String, Object>> selectFail(){
		return studentMapper.selectFail();
	}
	//查询各院系各课程平均成绩
	public List<Map<String, Object>> selectAVGByCol(){
		return studentMapper.selectAVGByCol();
	}
	//查询各院系性别人数
	public List<Map<String, Object>> selectCountBySex(){
		return studentMapper.selectCountBySex();
	}
	//======================简单维护========================
	
	//学生删除
	public void deleteById(String stuid){
		studentMapper.deleteByPrimaryKey(stuid);
	}
	
	//学生更新
	public void updateStu(Student student){
		studentMapper.updateByPrimaryKeySelective(student);
	}
	
	//学生保存
	public void saveStudent(Student student){
		studentMapper.insertSelective(student);
	}
}
