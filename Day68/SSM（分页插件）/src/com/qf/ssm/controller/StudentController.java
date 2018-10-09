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
 * Mybatis�Ĳ�� - ������
 * һ�����������SpringMVC��Struts2��ͨ���������Լ���д�ķ���
 * Mybatis�����������ص����Ĵ�����е�ĳ������
 * 
 * Mybatis����������ԭ��
 * 
 * ��ҳ��� - ���������ķ�ҳ����
 * select * from student
 * 1����prepare������������
 * 2�����ִ�е�sql��� - ȷ���Ƿ�Ҫ���з�ҳ select
 * 3���������ݿ������ select count(*) from student
 * 4��ִ��select * from student limiter ?,?
 * 5�����������
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
