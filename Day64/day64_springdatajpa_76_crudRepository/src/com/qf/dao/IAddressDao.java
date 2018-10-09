package com.qf.dao;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import com.qf.entity.Address;

@RepositoryDefinition(domainClass=Address.class, idClass = Integer.class)
public interface IAddressDao {

	public Address getAddressById(Integer id);
	
	// _代表id是Student中的属性
	// _级联查询的时候使用
	public List<Address> getAddressByStudent_Id(Integer stuId);
}
