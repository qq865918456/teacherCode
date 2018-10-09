package com.qf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.dao.IStudentDao;
import com.qf.entity.Page;
import com.qf.entity.Student;
import com.qf.service.IStudentService;

@Controller
@RequestMapping(value="/studentController")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/getStudentPage")
	public String getStudentPage(Page<Student> page,ModelMap map){
		org.springframework.data.domain.Page<Student> studentPage = studentService.getStudentPage(page);
		
		map.put("page", studentPage);
		map.put("url", "studentController/getStudentPage?");
		return "studentList";
	}

}
