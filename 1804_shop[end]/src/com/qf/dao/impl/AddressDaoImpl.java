package com.qf.dao.impl;

import java.util.List;

import com.qf.dao.IAddressDao;
import com.qf.entity.Address;
import com.qf.utils.DBUtils;

public class AddressDaoImpl implements IAddressDao {

	@Override
	public List<Address> getAddressByUserId(Integer userId) {
		String sql = "select * from t_address where user_id = ?";
		return DBUtils.commonQuery(sql, Address.class, userId);
	}

}
