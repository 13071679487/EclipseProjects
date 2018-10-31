package com.rifu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rifu.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController{

	private static List<Student> studentList = new ArrayList<>();

	static {
		studentList.add(new Student(1, "rifu1", 8));
		studentList.add(new Student(2, "rifu2", 8));
		studentList.add(new Student(3, "rifu3", 8));
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("studentList", studentList);
		mav.setViewName("student/list");
		return mav;
	}

	/**
	 * Ä¬ÈÏrequiredÎªtrue
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value = "id", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		if (id != null) {
			mav.addObject("student", studentList.get(Integer.parseInt(id) - 1));
			mav.setViewName("student/update");
		} else
			mav.setViewName("student/add");
		return mav;
	}

	@RequestMapping("/save")
	public String save(Student stu) {
		if (stu.getId() != 0) {
			Student s = studentList.get(stu.getId() - 1);
			s.setName(stu.getName());
			s.setAge(stu.getAge());
		} else
			studentList.add(stu);
		return "redirect:/student/list.do";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "id") int id){
		studentList.remove(id-1);
		return "redirect:/student/list.do";
	}
}
