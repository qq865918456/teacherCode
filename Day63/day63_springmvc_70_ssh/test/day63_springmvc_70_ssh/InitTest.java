package day63_springmvc_70_ssh;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sun.print.resources.serviceui;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class InitTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testDataSource() {
		System.out.println(dataSource);
	}
	
	@Test
	public void testSessionFactory() {
		
	}

}
