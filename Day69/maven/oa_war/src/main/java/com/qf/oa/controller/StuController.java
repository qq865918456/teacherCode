package com.qf.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.oa.entity.Student;
import com.qf.oa.service.IStuService;

@Controller
@RequestMapping("/stu")
public class StuController {

	@Autowired
	private IStuService stuService;
	
	@RequestMapping("/queryall")
	public String queryAll(Model model){
		List<Student> stus = stuService.queryAll();
		System.out.println("调用service：" + stus);
		model.addAttribute("stus", stus);
		return "stulist";
	}
}
