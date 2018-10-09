package com.qf.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.dao.InfoMationDao;
import com.qf.entity.InfoMation;
import com.qf.entity.User;
import com.qf.service.IUserService;
import com.sun.xml.internal.stream.buffer.sax.SAXBufferProcessor;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TopicServiceImplTest {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private InfoMationDao ifDao;
	
	@Test
	public void testLogin(){
		User user = userService.login("admin", "admin");
		System.out.println(user);
	}
	@Test
	public void testTest(){
//		System.out.println(ifDao.getInfoMationCountByUser(1));
//		List<InfoMation> infoMationByTopicUserId = ifDao.getInfoMationByTopicUserIdAndState(1,0);
//		for (InfoMation infoMation : infoMationByTopicUserId) {
//			System.out.println(infoMation);
//		}
		ifDao.updateInfoMation(1);
	}
}
