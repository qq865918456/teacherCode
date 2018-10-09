package com.qf.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class InitTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Test
	public void testDataSource() {
		System.out.println(dataSource);
	}
	@Test
	public void testEntityManagerFactory() {
		System.out.println(entityManagerFactory);
	}

}
