package com.qf.dao.impl;

import java.util.List;

import com.qf.dao.IGoodsInfoDao;
import com.qf.entity.Goods;
import com.qf.entity.GoodsInfo;
import com.qf.utils.DBUtils;

public class GoodsInfoDaoImpl implements IGoodsInfoDao {

	@Override
	public int add(GoodsInfo t) {
		return 0;
	}

	@Override
	public int update(GoodsInfo t) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

	@Override
	public GoodsInfo getById(Integer id) {
		String sql = "select * from t_goods_info where id = ?";
		List<GoodsInfo> goodsList = DBUtils.commonQuery(sql, GoodsInfo.class, id);
		if (!goodsList.isEmpty()) {
			return goodsList.get(0);
		}
		return null;
	}

	@Override
	public List<GoodsInfo> getList(Integer index, Integer size) {
		return DBUtils.commonQuery("select * from t_goods_info limit ?,?", GoodsInfo.class, index, size);
	}

	@Override
	public int getCount() {
		return DBUtils.commonCount("select count(1) from t_goods_info");
	}

	@Override
	public List<GoodsInfo> getGoodsInfoList() {
		String sql = "select * from t_goods_info";
		return DBUtils.commonQuery(sql, GoodsInfo.class);
	}

}
