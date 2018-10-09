package com.qf.controller;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.entity.User;

@Controller
public class UserController {

	@RequestMapping(value = "/addUser")
	public String addUser(User user) {
		System.out.println("UserController.addUser()："+user);
		return "ok";
	}

	// 时间格式化参数默认值2018/12/12
	@InitBinder // 属性编辑器
	public void initBinder(WebDataBinder dataBinder){
		System.out.println("UserController.initBinder()");
		dataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
			/**
			 * text:表单输入内容
			 */
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				
				 try {
					 // 格式化
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
					
					setValue(date); // 给对象的属性赋值，调用对象的setXxx
				} catch (ParseException e) {
					setValue(null);
//					e.printStackTrace();
					System.out.println("格式化失败");
				}
				
			}
		});
	}
	
}
