package com.qf.dao;

import java.util.List;

import com.qf.entity.Topic;

public interface ITopicDao {
	
	int getTopicCount();
	
	 List<Topic> getTopicList(Integer start,Integer size);

	Topic getTopicById(Integer id);

}
