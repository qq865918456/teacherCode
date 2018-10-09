package com.qf.service;

import com.qf.entity.Page;
import com.qf.entity.User;

public interface IBaseService<T> {

	public int add(T t);

	public int update(T t);

	public int delete(Integer id);

	public T getById(Integer id);

	public void getPage(Page<T> page);
}
