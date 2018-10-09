package com.qf.entity;

public class GoodsInfo {
	
	private Integer id;
	
	private String goods_name;
	
	private String goods_descrip;
	
	private String goods_pic;
	
	private Double goods_price;
	
	private Integer goods_stock;
	
	private Double goods_price_off;
	
	private Double goods_discount;
	
	private Integer goods_fatherid;
	
	private Integer goods_parentid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_descrip() {
		return goods_descrip;
	}

	public void setGoods_descrip(String goods_descrip) {
		this.goods_descrip = goods_descrip;
	}

	public String getGoods_pic() {
		return goods_pic;
	}

	public void setGoods_pic(String goods_pic) {
		this.goods_pic = goods_pic;
	}

	public Double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}

	public Integer getGoods_stock() {
		return goods_stock;
	}

	public void setGoods_stock(Integer goods_stock) {
		this.goods_stock = goods_stock;
	}

	public Double getGoods_price_off() {
		return goods_price_off;
	}

	public void setGoods_price_off(Double goods_price_off) {
		this.goods_price_off = goods_price_off;
	}

	public Double getGoods_discount() {
		return goods_discount;
	}

	public void setGoods_discount(Double goods_discount) {
		this.goods_discount = goods_discount;
	}

	public Integer getGoods_fatherid() {
		return goods_fatherid;
	}

	public void setGoods_fatherid(Integer goods_fatherid) {
		this.goods_fatherid = goods_fatherid;
	}

	public Integer getGoods_parentid() {
		return goods_parentid;
	}

	public void setGoods_parentid(Integer goods_parentid) {
		this.goods_parentid = goods_parentid;
	}

	@Override
	public String toString() {
		return "GoodsInfo [id=" + id + ", goods_name=" + goods_name + ", goods_descrip=" + goods_descrip
				+ ", goods_pic=" + goods_pic + ", goods_price=" + goods_price + ", goods_stock=" + goods_stock
				+ ", goods_price_off=" + goods_price_off + ", goods_discount=" + goods_discount + ", goods_fatherid="
				+ goods_fatherid + ", goods_parentid=" + goods_parentid + "]";
	}
	
}
