package com.qf.dao;

import java.util.List;

import com.qf.entity.Address;

public interface IAddressDao {

	List<Address> getAddressByUserId(Integer userId);

}
