	package com.qf.controller;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.qf.entity.User;

@Controller
public class UserController {

	@RequestMapping(value = "/test")
	public String test() {
		System.out.println("UserController.test()");
		return "ok";
	}

	@RequestMapping(value = "/getString")
	public void getString(HttpServletResponse response) {
		System.out.println("UserController.getString()");
		// return "Hello World";
		try {
			response.getWriter().write("Hello World");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getString1")
	@ResponseBody // 把方法的返回值直接响应给浏览器，不当成视图解析
	public String getString1() {
		System.out.println("UserController.getString1()");
		return "Hello World";
	}

	@RequestMapping(value = "/getJson")
	@ResponseBody // 把方法的返回值直接响应给浏览器，不当成视图解析
	public String getJson() {
		
		// 1.准备一个集合
		List<User> userList = new ArrayList<User>();
		
		// 2.往集合中添加10个对象
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId(i+1);
			user.setUsername("name_" + i);
			user.setPassword("pw_" + i);
			userList.add(user);
		}
		
		// 3.把集合转出JSON字符串
		String json = new Gson().toJson(userList);
		
		return json;
	}

}
