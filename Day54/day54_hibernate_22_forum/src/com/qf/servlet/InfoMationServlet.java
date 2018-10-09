package com.qf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.InfoMation;
import com.qf.entity.User;
import com.qf.service.IInfoMationService;
import com.qf.service.impl.InfoMationServiceImpl;

/**
 * Servlet implementation class InfoMationServlet
 */
public class InfoMationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IInfoMationService infService = new InfoMationServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoMationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("getInfoMationCount".equals(action)) {
			User user = (User)request.getSession().getAttribute("user");
			int count = infService.getInfoMationCountByUser(user);
			response.getWriter().write(count+"");
		}else if("getInfoMactionList".equals(action)){
			User user = (User)request.getSession().getAttribute("user");
			
			// 1.查询所有消息
			List<InfoMation> infoMations = infService.getInfoMactionList(user);
			
			if(!infoMations.isEmpty()){
				// 2.更新消息
				infService.updateInfoMation(user,infoMations);
			}
			request.setAttribute("infoMations", infoMations);
			request.getRequestDispatcher("infoMationList.jsp").forward(request, response);
		}
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
