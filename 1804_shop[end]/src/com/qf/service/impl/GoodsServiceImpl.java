package com.qf.service.impl;

import java.util.List;

import com.qf.dao.IGoodsDao;
import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.entity.Goods;
import com.qf.entity.Page;
import com.qf.entity.User;
import com.qf.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {

	private IGoodsDao goodsDao = new GoodsDaoImpl();

	@Override
	public int add(Goods t) {
		return goodsDao.add(t);
	}

	@Override
	public int update(Goods t) {
		return goodsDao.update(t);
	}

	@Override
	public int delete(Integer id) {
		return goodsDao.delete(id);
	}

	@Override
	public Goods getById(Integer id) {
		return goodsDao.getById(id);
	}

	@Override
	public void getPage(Page<Goods> page) {

		Integer currentPage = page.getCurrentPage();
		Integer pageSize = page.getPageSize();

		int count = goodsDao.getCount();

		List<Goods> list = goodsDao.getList((currentPage - 1) * pageSize, pageSize);

		page.setTotalCount(count);
		page.setData(list);
	}

	@Override
	public List<Goods> getParentGoodsList() {
		return goodsDao.getParentGoodsList();
	}

	@Override
	public List<Goods> getGoodsListByParentId(Integer id) {
		return goodsDao.getGoodsListByParentId(id);
	}

	@Override
	public List<Goods> getGoodsList() {
		return goodsDao.getGoodsList();
	}

}
