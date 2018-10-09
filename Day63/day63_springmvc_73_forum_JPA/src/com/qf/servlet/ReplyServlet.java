package com.qf.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.InfoMation;
import com.qf.entity.Reply;
import com.qf.entity.Topic;
import com.qf.entity.User;
import com.qf.service.IInfoMationService;
import com.qf.service.IReplyService;
import com.qf.service.impl.InfoMationServiceImpl;
import com.qf.service.impl.ReplyServiceImpl;

import sun.net.TelnetProtocolException;

/**
 * Servlet implementation class ReplyServlet
 */
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IReplyService replyService = new ReplyServiceImpl();
	private IInfoMationService infService = new InfoMationServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("addReply".equals(action)){
			
			// 1.判断用户是否登录
			User user = (User)request.getSession().getAttribute("user");
			if(user == null){
				request.setAttribute("msg", "你没有能录，请先登录！！！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return ;
			}
			
			// 1.获取表单参数
			String topicId = request.getParameter("topicId");
			String content = request.getParameter("content");
			
			Reply reply = new Reply();
			reply.setContent(content);
			
			Topic topic= new Topic();
			topic.setId(Integer.parseInt(topicId));
			
			reply.setReplyTopic(topic);
			reply.setCreateDate(new Date());
			reply.setReplyUser(user);
			
			int replyId = replyService.add(reply); // 保存
			
			reply.setId(replyId);
			
			// 添加消息
			InfoMation infoMation = new InfoMation();
			infoMation.setTopic(topic);
			infoMation.setReply(reply);
			infService.addInfoMation(infoMation);
			
//			request.getRequestDispatcher("").forward(request, response);
			response.sendRedirect("TopicServlet?action=getTopicById&id="+topicId);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
