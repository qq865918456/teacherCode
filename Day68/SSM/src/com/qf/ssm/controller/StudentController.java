package com.qf.ssm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.ssm.entity.Student;
import com.qf.ssm.service.IStuService;

@Controller
public class StudentController {

	@Autowired
	private IStuService stuService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String test(){
		List<Student> stus = stuService.queryAll();
		System.out.println(stus);
		return "ok!";
	}
}
