package com.qf.service;

import com.qf.entity.Page;

public interface IBaseService<T> {
	
	public int add(T t);

	public void getPage(Page<T> page);

	public T getById(Integer id);

	public int update(T t);

	public int delete(Integer id);

}
