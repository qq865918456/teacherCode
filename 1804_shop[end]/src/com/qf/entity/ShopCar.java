package com.qf.entity;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.omg.CORBA.INTERNAL;

import com.qf.domain.GoodsInfoDomain;

/**
 * 购物车对象
 * 
 * @author admin
 *
 */
public class ShopCar {

	private List<GoodsInfoDomain> list = new ArrayList<GoodsInfoDomain>();

	/**
	 * 往购物车中添加商品
	 * 
	 * @param goodsInfo
	 */
	public void add(GoodsInfoDomain goodsInfo) {
		Boolean flag = true; // true代表不存在
		for (GoodsInfoDomain goodsInfoDomain : list) {
			if(goodsInfo.getId().equals(goodsInfoDomain.getId())){
				flag = false;
				int count = goodsInfoDomain.getCount(); // 之前的数量
				int newCount = goodsInfo.getCount();
				goodsInfoDomain.setCount(count+newCount);
				break;
			}
		}
		
		if(flag){
			list.add(goodsInfo);
		}
		
	}

	/**
	 * 删除购物车中的商品
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		for (GoodsInfoDomain goodsInfo : getList()) {
			if (goodsInfo.getId().equals(id)) {
				getList().remove(goodsInfo);
				break; // 删除完成后要马上返回
			}
		}
	}

	/**
	 * 算出价格
	 * 
	 * @return
	 */
	public Double getPrice() {
		Double price =0.0;
		for (GoodsInfoDomain goodsInfoDomain : list) {
			price +=goodsInfoDomain.getGoods_price_off()*goodsInfoDomain.getCount();
		}
		return price;
	}

	/**
	 * 购物车中商品的总数
	 * 
	 * @return
	 */
	public Integer getCount() {
		Integer count = 0;
		for (GoodsInfoDomain goodsInfoDomain : list) {
			count +=goodsInfoDomain.getCount();
		}
		return count;
	}

	public static ShopCar getShopCarIns(HttpSession session) {

		ShopCar shopCar = (ShopCar) session.getAttribute("shopCar");

		if (shopCar == null) { // 如果为空说明是第一次获取购物车对象
			shopCar = new ShopCar();
			session.setAttribute("shopCar", shopCar);
		}

		return shopCar;
	}

	public List<GoodsInfoDomain> getList() {
		return list;
	}

	public void setList(List<GoodsInfoDomain> list) {
		this.list = list;
	}

}
