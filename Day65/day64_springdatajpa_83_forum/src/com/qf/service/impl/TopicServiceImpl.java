package com.qf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qf.dao.ITopicDao;
import com.qf.entity.Page;
import com.qf.entity.Topic;
import com.qf.service.ITopicService;

@Service
public class TopicServiceImpl implements ITopicService {

	@Autowired
	private ITopicDao topicDao;
	
	@Override
	public org.springframework.data.domain.Page<Topic> getTopicPage(Page<Topic> page) {
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
//		page.setTotalCount(topicDao.getTopicCount());
//		page.setData(topicDao.getTopicList((currentPage-1)*pageSize, pageSize));
		
		Pageable pageable = new PageRequest(currentPage-1, pageSize);
		return  topicDao.findAll(pageable);
	}

	@Override
	public Topic getTopicById(Integer id) {
		return topicDao.findOne(id);
	}

}
