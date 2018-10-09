package com.qf.service;

import com.qf.entity.Customer;
import com.qf.entity.Page;

public interface ICustomerService {

	public int addCustomer(Customer customer);
	
	public int udpateCustomer(Customer customer);
	
	public Customer getCustomerById(Integer id );
	
	public int deleteCustomer(Integer id);
	
	public void getCustomerPage(Page<Customer> page);
}
