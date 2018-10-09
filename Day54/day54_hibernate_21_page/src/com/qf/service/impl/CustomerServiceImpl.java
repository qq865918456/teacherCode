package com.qf.service.impl;

import java.util.List;

import com.qf.dao.ICustomerDao;
import com.qf.dao.impl.CustomerDaoImpl;
import com.qf.entity.Customer;
import com.qf.entity.Page;
import com.qf.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public int addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public int udpateCustomer(Customer customer) {
		return customerDao.udpateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public int deleteCustomer(Integer id) {
		return customerDao.deleteCustomer(id);
	}

	@Override
	public void getCustomerPage(Page<Customer> page) {
		
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		// 1.算出总条数
		int totalCount = customerDao.getCustomerCount();

		// 2.当前页要显示数据
		List<Customer> customerList = customerDao.getCustomerList((currentPage-1)*pageSize, pageSize);
		
		// 3.封装
		page.setTotalCount(totalCount);
		page.setData(customerList);

	}

}
