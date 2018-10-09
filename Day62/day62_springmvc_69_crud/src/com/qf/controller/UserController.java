package com.qf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.entity.User;

@Controller
@RequestMapping(value="/userController")
public class UserController {

	@RequestMapping(value = "/addUser")
	public String addUser(User user) {
		System.out.println("UserController.addUser()：" + user);
		return "ok";
	}

	@RequestMapping(value = "/getUserList")
	public String getUserList(ModelMap map) {
		// 1.造数据
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setId(i+1);
			user.setUsername("name_" + i);
			user.setPassword("pasword_" + i);
			user.setAge(1);
			user.setBrithday(new Date());
			userList.add(user);
		}
		
		// 2.放到作用域
		map.put("userList", userList);
		
		// 3.转发
		return "userList";
	}
	
	@RequestMapping(value="deletUser/{id}")
	public String deleteUser(@PathVariable("id")Integer id){
		System.out.println("id:"+id);
		// day62_springmvc_69_crud/deleteUser/12
		// day62_springmvc_69_crud/deleteUser/getUserList
		return "redirect:../getUserList";
	}
}
