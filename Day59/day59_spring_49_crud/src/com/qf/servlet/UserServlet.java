package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.w3c.dom.ls.LSException;

import com.qf.dao.impl.UserDaoImpl;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IUserService;
import com.sun.org.apache.xerces.internal.impl.dv.dtd.IDDatatypeValidator;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		// 1.获取Spring容器对象
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
		
		// 2.在容器中后去userServiec对象
		IUserService userService = webApplicationContext.getBean(IUserService.class);
		
		if("getUserPage".equals(action)){
			
			String currentPage = request.getParameter("currentPage");
			String pageSize = request.getParameter("pageSize");
			
			Page<User> page = new Page<User>();
			
			if(currentPage != null && !"".equals(currentPage)){
				page.setCurrentPage(Integer.parseInt(currentPage));
				page.setPageSize(Integer.parseInt(pageSize));
			}
			userService.getUserPage(page);
			
			page.setUrl("UserServlet?action=getUserPage");
			request.setAttribute("page", page);
			request.getRequestDispatcher("userList.jsp").forward(request, response);
			
		}else if("deleteUser".equals(action)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			userService.deleteUser(id);
			
			response.sendRedirect("UserServlet?action=getUserPage");
		}else if("getUserById".equals(action)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			User user =userService.geUserById(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		}else if("updateUser".equals(action)){
			
			// 1.封装user
			User user = setUserEnitty(request);
			
			// 2.更新
			userService.updateUser(user);
			
			// 3.回到列表
			response.sendRedirect("UserServlet?action=getUserPage");
		}
	}

	private User setUserEnitty(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(id != null && !"".equals(id)){
			user.setId(Integer.parseInt(id));
		}
		return user;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
