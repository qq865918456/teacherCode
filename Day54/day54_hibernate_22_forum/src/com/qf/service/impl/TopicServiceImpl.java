package com.qf.service.impl;

import com.qf.dao.ITopicDao;
import com.qf.dao.impl.TopicDaoImpl;
import com.qf.entity.Page;
import com.qf.entity.Topic;
import com.qf.service.ITopicService;

public class TopicServiceImpl implements ITopicService {

	private ITopicDao topicDao = new TopicDaoImpl();
	
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
