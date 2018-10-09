package com.qf.service.impl;

import com.qf.dao.IBaseDao;
import com.qf.entity.Page;
import com.qf.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T>{

	// 定义这个方法的目标是为了子类父类，从而给IBaseDao实例化
	// 定义抽象方法的的原因是强制子类复写
	protected abstract IBaseDao<T> getBaseDao();
	
	@Override
	public int add(T t) {
		return getBaseDao().add(t);
	}

	@Override
	public void getPage(Page<T> page) {
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		page.setData(getBaseDao().getList((currentPage-1)*pageSize, pageSize));
		page.setTotalCount(getBaseDao().getCount());
		
	}

	@Override
	public T getById(Integer id) {
		return getBaseDao().getById(id);
	}

	@Override
	public int update(T t) {
		return getBaseDao().baseUpdate(t);
	}

	@Override
	public int delete(Integer id) {
		return getBaseDao().delete(id);
	}

}
