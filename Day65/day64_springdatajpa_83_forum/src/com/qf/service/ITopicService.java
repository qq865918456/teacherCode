package com.qf.service;

import com.qf.entity.Page;
import com.qf.entity.Topic;

public interface ITopicService {

	public org.springframework.data.domain.Page<Topic> getTopicPage(Page<Topic> page);

	public Topic getTopicById(Integer id);
	
}
