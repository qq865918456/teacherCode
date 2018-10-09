package com.qf.dao;

import java.util.List;

import com.qf.entity.Customer;

public interface ICustomerDao {

	public int addCustomer(Customer customer);
	
	public int udpateCustomer(Customer customer);
	
	public Customer getCustomerById(Integer id );
	
	public int deleteCustomer(Integer id);
	
	public int getCustomerCount();
	
	public List<Customer> getCustomerList(Integer start,Integer size);
}
