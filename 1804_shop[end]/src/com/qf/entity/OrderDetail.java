package com.qf.entity;

import java.util.Date;

public class OrderDetail {

	private Integer id;
	
	/**
	 * 下单时间
	 */
	private Date goods_date; 
	
	/**
	 * 订单id
	 */
	private Integer o_orderid;
	
	/**
	 * 商品id
	 */
	private Integer goodsid;
	
	
	/**
	 * 商品名称
	 */
	private String goodsname;
	
	/**
	 * 商品价格
	 */
	private Double goodsprice;
	
	
	/**
	 * 商品的描述
	 */
	private String goods_description;
	
	/**
	 * 商品的数量
	 */
	private Integer goodsnum;
	
	/**
	 * 商品图片
	 */
	private String goodspic;
	
	/**
	 * 商品的小计
	 */
	private Double goods_total_price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getGoods_date() {
		return goods_date;
	}

	public void setGoods_date(Date goods_date) {
		this.goods_date = goods_date;
	}

	public Integer getO_orderid() {
		return o_orderid;
	}

	public void setO_orderid(Integer o_orderid) {
		this.o_orderid = o_orderid;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Double getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(Double goodsprice) {
		this.goodsprice = goodsprice;
	}

	public String getGoods_description() {
		return goods_description;
	}

	public void setGoods_description(String goods_description) {
		this.goods_description = goods_description;
	}

	public Integer getGoodsnum() {
		return goodsnum;
	}

	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}

	public String getGoodspic() {
		return goodspic;
	}

	public void setGoodspic(String goodspic) {
		this.goodspic = goodspic;
	}

	public Double getGoods_total_price() {
		return goods_total_price;
	}

	public void setGoods_total_price(Double goods_total_price) {
		this.goods_total_price = goods_total_price;
	}
	
	

	
}
