package com.qf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qf.entity.Topic;

public interface ITopicDao extends JpaRepository<Topic, Integer>{
	
}
