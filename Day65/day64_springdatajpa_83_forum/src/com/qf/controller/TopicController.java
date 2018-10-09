package com.qf.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.entity.Page;
import com.qf.entity.Reply;
import com.qf.entity.Topic;
import com.qf.service.IReplyService;
import com.qf.service.ITopicService;
import com.qf.service.impl.ReplyServiceImpl;
import com.qf.service.impl.TopicServiceImpl;


@Controller
@RequestMapping(value="/topicController")
public class TopicController{

	@Autowired
	private ITopicService topicService;
	
	@Autowired
	private IReplyService replyService;
	
	
	@RequestMapping(value="/getTopicPage")
	public String getTopicPage(Page<Topic> page,ModelMap map){
		
		org.springframework.data.domain.Page<Topic> topicPage = topicService.getTopicPage(page);;
		map.put("url","topicController/getTopicPage?");
		map.put("page", topicPage);
		return "topicList";
	}
	
	@RequestMapping(value="/getTopicById/{id}")
	public String getTopicById(Page<Reply> page,@PathVariable Integer id,ModelMap map){
		
		// 1.查询帖子信息
		Topic topic = topicService.getTopicById(id);
		
		// 2.查询帖子的回复，分页
		org.springframework.data.domain.Page<Reply> replyPage = replyService.getReplyPage(page,id);
		
		map.put("url","topicController/getTopicById/"+id+"?"); // 下一页的时候要传递帖子id
		map.put("topic", topic);
		map.put("page", replyPage);
		return "topicInfo";
	}
}
