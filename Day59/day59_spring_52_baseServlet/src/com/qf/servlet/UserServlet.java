package com.qf.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.qf.entity.Page;
import com.qf.entity.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {

//	public String addUser() {
//		System.out.println("UserServlet.addUser()");
//		return "forward:ok.jsp"; // 转发到ok.jsp
//		// return "redirect:ok.jsp"; // 重定向到ok.jsp
//	}

	public String addUser(User user) {
		System.out.println("UserServlet.addUser():" + user);
		return "forward:ok.jsp"; // 转发到ok.jsp
	}
	
	public String getUserPage(Page<User> page,Map<String, Object> map,HttpServletRequest request) {
		System.out.println("UserServlet.getUserPage() :"+page);
		String value = "hello";
		map.put("key", value);
		return "forward:ok.jsp"; // 转发到ok.jsp
	}

}
