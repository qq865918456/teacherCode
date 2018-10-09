package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.omg.CORBA.INTERNAL;

import com.qf.dao.impl.UserDaoImpl_temp;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;
import com.qf.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("getUserPage".equals(action)) {
			Page page = new Page();
			String currentPageTemp = request.getParameter("currentPage");
			if (currentPageTemp != null && !"".equals(currentPageTemp)) {
				page.setCurrentPage(Integer.parseInt(currentPageTemp));
			}
			page.setUrl("UserServlet?action=getUserPage");
			userService.getUserPage(page);
			request.setAttribute("page", page);
			request.getRequestDispatcher("back/user/userinfo.jsp").forward(request, response);
		} else if ("addUser".equals(action)) {

			// 1.获取表单中的数据
			User user = setEntityUser(request);

			// 3.添加
			int addUser = userService.addUser(user);
			if (addUser > 0) {
				response.sendRedirect("UserServlet?action=getUserPage");
			} else {
				response.getWriter()
						.write("<script>alert('添加失败');location.href='UserServlet?action=getUserPage'</script>");
			}
		} else if ("getUserById".equals(action)) {

			Integer id = Integer.parseInt(request.getParameter("id"));

			User user = userService.getUserById(id);

			request.setAttribute("user", user);

			request.getRequestDispatcher("back/user/updateuser.jsp").forward(request, response);
		} else if ("updateUser".equals(action)) {
			User user = setEntityUser(request);
			userService.updateUser(user);
			response.sendRedirect("UserServlet?action=getUserPage");

		} else if ("batchDel".equals(action)) {

			String name = request.getParameter("name");
			String[] ids = request.getParameterValues("ids[]");
			
			if (ids != null) {
				userService.batchDel(ids);
			}

		} else if ("backLogin".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// 1.根据用户名和密码查询用户
			User user = userService.login(username, password);
			if(user != null){
				
				// 2.判断是否是管理员
				if("1".equals(user.getRole().toString())){
					// 登录成功后把用户对象放入到session中
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("/back/main.jsp").forward(request, response);
				}else{
					response.getWriter().write("<script>alert('你不是管理员！请联系管理员');location.href='backLogin.jsp'</script>");
				}
			}else{
				// 登录失败
				response.getWriter().write("<script>alert('用户名或密码错误！');location.href='backLogin.jsp'</script>");
//				request.getRequestDispatcher("backLogin.jsp").forward(request, response);
			}
		}
	}

	private User setEntityUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String role = request.getParameter("role");
		String email = request.getParameter("email");
		String id = request.getParameter("id");

		// 2.封装user对象
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(Integer.parseInt(sex));
		user.setRole(Integer.parseInt(role));
		user.setEmail(email);
		if (id != null && !"".equals(id)) { // 添加的用户的时候id是空值
			user.setId(Integer.parseInt(id));
		}
		return user;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
