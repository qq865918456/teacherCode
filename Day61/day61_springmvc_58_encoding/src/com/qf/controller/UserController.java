package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qf.entity.User;

@Controller
public class UserController {

	@RequestMapping(value="addUser")
	public String addUser(User user) {
		System.out.println(user);
		return "ok";
	}
}
