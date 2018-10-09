package com.qf.dao.impl;

import java.util.List;

import com.qf.dao.IGoodsDao;
import com.qf.entity.Goods;
import com.qf.entity.User;
import com.qf.utils.DBUtils;

public class GoodsDaoImpl implements IGoodsDao {

	@Override
	public int update(Goods t) {
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goods getById(Integer id) {
		String sql = "select * from t_Goods where id = ?";
		List<Goods> goodsList = DBUtils.commonQuery(sql, Goods.class, id);
		if (!goodsList.isEmpty()) {
			return goodsList.get(0);
		}
		return null;
	}

	@Override
	public List<Goods> getList(Integer index, Integer size) {
		String sql = "SELECT g1.*,  ifnull(g2.goodsname,'无') as goodsparentname FROM t_goods g1 left JOIN t_goods g2 ON (g1.goodsparentid = g2.id) limit ?,?";
		return DBUtils.commonQuery(sql, Goods.class, index, size);
	}

	@Override
	public int getCount() {
		return DBUtils.commonCount("select count(1) from t_goods");
	}

	@Override
	public int add(Goods t) {
		String sql = "insert into t_goods(goodsname,goodsparentid) values(?,?)";
		return DBUtils.commonUpdate(sql, t.getGoodsname(), t.getGoodsparentid());
	}

	@Override
	public List<Goods> getParentGoodsList() {
		String sql = "select * from t_Goods where goodsparentid = 0";
		return DBUtils.commonQuery(sql, Goods.class);
	}

	@Override
	public List<Goods> getGoodsListByParentId(Integer id) {
		return DBUtils.commonQuery("select * from t_goods where goodsparentid = ?", Goods.class, id);
	}

	@Override
	public List<Goods> getGoodsList() {
		String sql = "select * from t_goods";
		return DBUtils.commonQuery(sql, Goods.class);
	}

}
