package com.qf.service;

import com.qf.entity.OrderInfo;

public interface IOrderInfoService {

	/**
	 * 添加订单
	 * @param orderInfo 订单对象
	 * @return 主键
	 */
	public int addOrderInfo(OrderInfo orderInfo);
}
