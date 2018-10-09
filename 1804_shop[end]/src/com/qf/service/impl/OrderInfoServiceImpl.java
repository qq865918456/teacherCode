package com.qf.service.impl;

import com.qf.dao.IOrderInfoDao;
import com.qf.dao.impl.OrderInfoDaoImpl;
import com.qf.entity.OrderInfo;
import com.qf.service.IOrderInfoService;

public class OrderInfoServiceImpl implements IOrderInfoService {

	private IOrderInfoDao dao = new OrderInfoDaoImpl();
	
	@Override
	public int addOrderInfo(OrderInfo orderInfo) {
		return dao.addOrderInfo(orderInfo);
	}

}
