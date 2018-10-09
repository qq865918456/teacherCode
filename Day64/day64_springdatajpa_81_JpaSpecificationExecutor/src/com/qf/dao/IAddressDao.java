package com.qf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.qf.entity.Address;

public interface IAddressDao  extends JpaRepository<Address, Integer>,JpaSpecificationExecutor<Address>{

}
