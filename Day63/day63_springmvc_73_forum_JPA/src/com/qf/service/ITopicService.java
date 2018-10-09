package com.qf.service;

import com.qf.entity.Page;
import com.qf.entity.Topic;

public interface ITopicService {

	public void getTopicPage(Page<Topic> page);

	public Topic getTopicById(Integer id);
	
}
