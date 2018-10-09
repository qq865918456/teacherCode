package com.qf.entity;

import java.util.HashSet;
import java.util.Set;


// customer.getOrderInfo(); // 得到这个客户的所有的订单

public class Customer {

	private Integer id;
	
	private String name;
	
	// 客户和订单是一对多
	private Set<OrderInfo> orderInfo = new HashSet<OrderInfo>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<OrderInfo> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(Set<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
}
