package com.qf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.ITopicDao;
import com.qf.dao.impl.TopicDaoImpl;
import com.qf.entity.Page;
import com.qf.entity.Topic;
import com.qf.service.ITopicService;

@Service
public class TopicServiceImpl implements ITopicService {

	@Autowired
	private ITopicDao topicDao;
	
	@Override
	public void getTopicPage(Page<Topic> page) {
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		page.setTotalCount(topicDao.getTopicCount());
		page.setData(topicDao.getTopicList((currentPage-1)*pageSize, pageSize));
	}

	@Override
	public Topic getTopicById(Integer id) {
		return topicDao.getTopicById(id);
	}

}
