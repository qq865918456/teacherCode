package com.qf.dao.impl;

import com.qf.dao.IOrderInfoDao;
import com.qf.entity.OrderInfo;
import com.qf.utils.DBUtils;

public class OrderInfoDaoImpl implements IOrderInfoDao {

	@Override
	public int addOrderInfo(OrderInfo o) {
		String sql ="insert into t_order(o_sendtype ,o_paytype ,o_paycount ,o_orderdate ,userid ,o_shperson ,o_shphone ,o_shaddress) values(?,?,?,?,?,?,?,?)";
		return DBUtils.commonInsert(sql, o.getO_sendtype(),o.getO_paytype(),o.getO_paycount(),o.getO_orderdate(),o.getUserid(),o.getO_shperson(),o.getO_shphone(),o.getO_shaddress());
	}

}
