package com.qf.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qf.entity.Student;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {

	public String register(Student s, HttpServletRequest req, Integer a, HttpSession session){
		System.out.println("用户注册");
		System.out.println(s);
		System.out.println(req);
		System.out.println(a);
		System.out.println(session);
		return "succ.jsp";
	}
	
	public String queryOne(){
		System.out.println("用户查询");
		return null;
	}
}
