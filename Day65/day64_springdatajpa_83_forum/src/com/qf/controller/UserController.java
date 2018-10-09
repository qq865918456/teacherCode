package com.qf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.entity.User;
import com.qf.service.IUserService;

@Controller
@RequestMapping(value="/userController")
public class UserController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value="/login")
	public String login(String username,String password,ModelMap map,HttpSession session){
		User user = userService.login(username, password);
		if (user == null) {
			map.put("msg", "用户名或密码错误");
			return "login";
		}else{
			session.setAttribute("user", user);
			// SpringMVC中的重定向中/代表的是项目的根目录
			return "redirect:/topicController/getTopicPage";
		}
	}
}
