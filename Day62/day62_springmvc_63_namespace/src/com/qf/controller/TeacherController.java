package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/teacherController")
public class TeacherController {

	@RequestMapping(value = "/add")
	public String add() {
		System.out.println("TeacherController.add()");
		return "ok";
	}
}
