package com.qf.service.impl;

import java.util.List;

import com.qf.dao.IGoodsInfoDao;
import com.qf.dao.impl.GoodsInfoDaoImpl;
import com.qf.entity.GoodsInfo;
import com.qf.entity.Page;
import com.qf.service.IGoodsInfoService;

public class GoodsInfoServiceImpl implements IGoodsInfoService {

	private IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
	
	@Override
	public int add(GoodsInfo t) {
		return goodsInfoDao.add(t);
	}

	@Override
	public int update(GoodsInfo t) {
		return goodsInfoDao.update(t);
	}

	@Override
	public int delete(Integer id) {
		return goodsInfoDao.delete(id);
	}

	@Override
	public GoodsInfo getById(Integer id) {
		return goodsInfoDao.getById(id);
	}

	@Override
	public void getPage(Page<GoodsInfo> page) {
		
		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();
		
		page.setTotalCount(goodsInfoDao.getCount());
		page.setData(goodsInfoDao.getList((currentPage-1)*pageSize, pageSize));
		
	}

	@Override
	public List<GoodsInfo> getGoodsInfoList() {
		return goodsInfoDao.getGoodsInfoList();
	}

}
