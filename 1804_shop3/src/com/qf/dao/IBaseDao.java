package com.qf.dao;

import java.util.List;

import com.qf.entity.User;

public interface IBaseDao<T> {

	public int add(T t);
	
	public int update(T t);

	public int delete(Integer id);

	public T getById(Integer id);

	public List<T> getList(Integer index, Integer size);

	public int getCount();
}
