package com.qf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import com.qf.entity.Page;
import com.qf.entity.Reply;
import com.qf.entity.Topic;
import com.qf.service.IReplyService;
import com.qf.service.ITopicService;
import com.qf.service.impl.ReplyServiceImpl;
import com.qf.service.impl.TopicServiceImpl;

/**
 * Servlet implementation class TopicServlet
 */
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ITopicService topicService = new TopicServiceImpl();
	private IReplyService replyService =new ReplyServiceImpl();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("getTopicPage".equals(action)){
			
			Page<Topic>  page = new Page<Topic>();
			
			// 封装分页参数
			setPageParam(request,page);
			
			topicService.getTopicPage(page);;
			
			page.setUrl("TopicServlet?action=getTopicPage");
			request.setAttribute("page", page);
			request.getRequestDispatcher("topicList.jsp").forward(request, response);
		}else if("getTopicById".equals(action)){
			Integer id = Integer.parseInt(request.getParameter("id"));
			// 1.查询帖子信息
			Topic topic = topicService.getTopicById(id);
			
			// 2.查询帖子的回复，分页
			Page<Reply>  page = new Page<Reply>();
			setPageParam(request,page);
			replyService.getReplyPage(page,id);
			page.setUrl("TopicServlet?action=getTopicById&id="+id); // 下一页的时候要传递帖子id
			
			request.setAttribute("topic", topic);
			request.setAttribute("page", page);
			request.getRequestDispatcher("topicInfo.jsp").forward(request, response);
				
		}
	}

	private void setPageParam(HttpServletRequest request,Page<?> page) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
	
		if(currentPage != null && !"".equals(currentPage)){
			page.setCurrentPage(Integer.parseInt(currentPage));
			page.setPageSize(Integer.parseInt(pageSize));
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
