package com.qf.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import com.qf.entity.Customer;
import com.qf.entity.Page;
import com.qf.service.impl.CustomerServiceImpl;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_COLOR_BURNPeer;

public class CustomerServiceImplTest {

	private ICustomerService customerSerivce = new CustomerServiceImpl();

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer();
		customer.setName("王五");
		customer.setPassword("123");
		System.out.println(customerSerivce.addCustomer(customer));
	}

	@Test
	public void testUdpateCustomer() {
		Customer customer = new Customer();
		customer.setName("王五1");
		customer.setPassword("123a");
		customer.setId(24);
		System.out.println(customerSerivce.udpateCustomer(customer));
	}

	@Test
	public void testGetCustomerById() {
		System.out.println(customerSerivce.getCustomerById(24));
	}

	@Test
	public void testDeleteCustomer() {
		System.out.println(customerSerivce.deleteCustomer(24));
	}

	@Test
	public void testGetCustomerPage() {
		Page<Customer> page = new Page<Customer>();
		customerSerivce.getCustomerPage(page);
		System.out.println(page);
	}

}
