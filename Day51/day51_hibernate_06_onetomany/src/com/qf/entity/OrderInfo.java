package com.qf.entity;


// orderInfo.getCustomeorId();
public class OrderInfo {

	private Integer id;
	
	private String orderName;

	// 订单和客户多对一关系
	private Customer customer;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
