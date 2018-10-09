package com.qf.domain;

public class GoodsInfoDomain {
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
	
	private Integer count;

	@Override
	public String toString() {
		return "GoodsInfoDomain [id=" + id + ", goods_name=" + goods_name + ", goods_descrip=" + goods_descrip
				+ ", goods_pic=" + goods_pic + ", goods_price=" + goods_price + ", goods_stock=" + goods_stock
				+ ", goods_price_off=" + goods_price_off + ", goods_discount=" + goods_discount + ", goods_fatherid="
				+ goods_fatherid + ", goods_parentid=" + goods_parentid + ", count=" + count + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((goods_descrip == null) ? 0 : goods_descrip.hashCode());
		result = prime * result + ((goods_discount == null) ? 0 : goods_discount.hashCode());
		result = prime * result + ((goods_fatherid == null) ? 0 : goods_fatherid.hashCode());
		result = prime * result + ((goods_name == null) ? 0 : goods_name.hashCode());
		result = prime * result + ((goods_parentid == null) ? 0 : goods_parentid.hashCode());
		result = prime * result + ((goods_pic == null) ? 0 : goods_pic.hashCode());
		result = prime * result + ((goods_price == null) ? 0 : goods_price.hashCode());
		result = prime * result + ((goods_price_off == null) ? 0 : goods_price_off.hashCode());
		result = prime * result + ((goods_stock == null) ? 0 : goods_stock.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsInfoDomain other = (GoodsInfoDomain) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (goods_descrip == null) {
			if (other.goods_descrip != null)
				return false;
		} else if (!goods_descrip.equals(other.goods_descrip))
			return false;
		if (goods_discount == null) {
			if (other.goods_discount != null)
				return false;
		} else if (!goods_discount.equals(other.goods_discount))
			return false;
		if (goods_fatherid == null) {
			if (other.goods_fatherid != null)
				return false;
		} else if (!goods_fatherid.equals(other.goods_fatherid))
			return false;
		if (goods_name == null) {
			if (other.goods_name != null)
				return false;
		} else if (!goods_name.equals(other.goods_name))
			return false;
		if (goods_parentid == null) {
			if (other.goods_parentid != null)
				return false;
		} else if (!goods_parentid.equals(other.goods_parentid))
			return false;
		if (goods_pic == null) {
			if (other.goods_pic != null)
				return false;
		} else if (!goods_pic.equals(other.goods_pic))
			return false;
		if (goods_price == null) {
			if (other.goods_price != null)
				return false;
		} else if (!goods_price.equals(other.goods_price))
			return false;
		if (goods_price_off == null) {
			if (other.goods_price_off != null)
				return false;
		} else if (!goods_price_off.equals(other.goods_price_off))
			return false;
		if (goods_stock == null) {
			if (other.goods_stock != null)
				return false;
		} else if (!goods_stock.equals(other.goods_stock))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
