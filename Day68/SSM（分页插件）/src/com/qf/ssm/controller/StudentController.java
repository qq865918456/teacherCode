package com.qf.ssm.controller;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.PropertyValuesEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.ssm.entity.Student;
import com.qf.ssm.interceptor.Page;
import com.qf.ssm.interceptor.PagePlugin;
import com.qf.ssm.service.IStuService;

/**
 * Mybatis的插件 - 拦截器
 * 一般的拦截器（SpringMVC、Struts2）通常是拦截自己编写的方法
 * Mybatis的拦截器拦截的是四大对象中的某个方法
 * 
 * Mybatis的拦截器的原理：
 * 
 * 分页插件 - （第三方的分页）：
 * select * from student
 * 1、对prepare方法进行拦截
 * 2、获得执行的sql语句 - 确定是否要进行分页 select
 * 3、计算数据库的条数 select count(*) from student
 * 4、执行select * from student limiter ?,?
 * 5、将结果返回
 * 
 * @author ken
 *
 */
@Controller
public class StudentController{

	@Autowired
	private IStuService stuService;
	
	@RequestMapping("/stuManager")
	public String test(Model model, Page page){
		List<Student> stus = stuService.queryAll();
		model.addAttribute("stus", stus);
		return "stumanager";
	}
}
