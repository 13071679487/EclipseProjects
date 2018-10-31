package com.mvc.app.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mvc.app.dao.MajorMapper;
import com.mvc.app.dao.StudentMapper;
import com.mvc.app.dao.TeacherMapper;
import com.mvc.app.model.Major;
import com.mvc.app.model.Student;
import com.mvc.app.model.StudentExample;
import com.mvc.app.model.Teacher;
import com.mvc.app.service.MajorService;
import com.mvc.app.service.StudentService;
import com.mvc.app.service.TeacherService;
import com.mvc.app.model.StudentExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/spring-context.xml"})
public class MapperTest {

	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private TeacherMapper teacherDao;
	@Autowired
	private MajorMapper majorDao;
	@Autowired
	private StudentService studentService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private TeacherService teacherService;
	
	@Test 
	public void findStudentById(){
		Student student=studentDao.selectByPrimaryKey("AP0803704");
		System.out.println(student.getAccommodation());
	}
	@Test
	public void findTeacherById(){
		Teacher teacher=teacherDao.selectByPrimaryKey("005000010");
		System.out.println(teacher.getTname());
	}
	@Test
	public void majorcourse(){
		List<Major> selectByStuid = majorDao.selectByStuid("AP0803704");
		for(Major m:selectByStuid){
			System.out.println(m.getMcourseid());
		}
	}
	@Test
	public void studentmajor(){
		@SuppressWarnings("unchecked")
		List<Student> students=(List<Student>) studentDao.selectByPrimaryKeyWithCourseMajor("AP0803704");
		for(Student student:students){
			System.out.println(student.getMajors());
			
		}
	}
	@Test
	public void studentmajor1(){ 
		Student students=studentDao.selectByPrimaryKeyWithCourseMajor("AP0803704");
		
		if(students.getMajors().size()>0){
			
			System.out.println(students.getMajors().get(1).getScore());
		}

	}	
	@Test
	public void studentmajorExample(){ 
		List<Student> students= studentDao.selectByExampleWithCourseMajor(null);
		for(Student student:students){
			System.out.println(student.getSname());
			
		}

	}
	
	@Test
	public void studentmajorExampleSex(){ 
		
		StudentExample example=new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andAddressEqualTo("广东");
		List<Student> student=studentDao.selectByExample(example);
		System.out.println(student.size());
	}
	
	@Test
	public void studenService(){ 
		
		Student student=studentService.selectByStuid("AP0803703");
		System.out.println(student.getSname());
	}

	@Test
	public void selectTeacherById(){ 
		
		
		System.out.println(teacherService.selectById("005000010").getTname());
	}
	
	
	
}
