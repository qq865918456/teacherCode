package com.qf.servlet;

import java.awt.SystemTray;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {

	private IUserService userService; // 让父类去初始化

	public String getUserPage(Page<User> page, HttpServletRequest request) {

		userService.getPage(page);
		page.setUrl("UserServlet?action=getUserPage");

		request.setAttribute("page", page);

		return "forward:userList.jsp";
	}
	
	public String deleteUser(Integer id) {
		userService.delete(id);
		return "redirect:UserServlet?action=getUserPage";
	}
	
	public String getUserById(Integer id,HttpServletRequest request) {
		User user = userService.getById(id);
		request.setAttribute("user", user);
		return "forward:updateUser.jsp";
	}
	
	public String updateUser(User user) {
		userService.update(user);
		return "redirect:UserServlet?action=getUserPage";
	}
	
	
	
}
