package com.qf.dao;

import java.util.List;

public interface IBaseDao<T> {

	public int add(T t);

	public int getCount();

	public List<T> getList(Integer index, Integer pageSize);

	public T getById(Integer id);

	public int baseUpdate(T t);

	public int delete(Integer id);
}
