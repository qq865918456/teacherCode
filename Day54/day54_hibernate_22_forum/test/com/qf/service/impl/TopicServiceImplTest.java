package com.qf.service.impl;

import static org.junit.Assert.*;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Test;

import com.qf.entity.Topic;
import com.qf.entity.User;
import com.qf.service.IInfoMationService;
import com.qf.service.ITopicService;
import com.qf.utils.HibernateUtil;

public class TopicServiceImplTest {

	private ITopicService topicService = new TopicServiceImpl();
	private IInfoMationService infService = new InfoMationServiceImpl();
	
	@Test
	public void testGetTopicById() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Topic topic = topicService.getTopicById(1);
		System.out.println(topic.getTitle());
	}
	
	@Test
	public void testInfoMaction() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user = new User();
		user.setId(1);
		int infoMationCountByUser = infService.getInfoMationCountByUser(user);
		System.out.println(infoMationCountByUser);
	}

}
