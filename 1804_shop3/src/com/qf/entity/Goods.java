package com.qf.entity;

public class Goods {

	private Integer id;

	private String goodsname;
	
	private Integer goodsparentid;
	
	private String goodspic;
	
	private String goodsparentname; // 父类名称

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Integer getGoodsparentid() {
		return goodsparentid;
	}

	public void setGoodsparentid(Integer goodsparentid) {
		this.goodsparentid = goodsparentid;
	}

	public String getGoodspic() {
		return goodspic;
	}

	public void setGoodspic(String goodspic) {
		this.goodspic = goodspic;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsname=" + goodsname + ", goodsparentid=" + goodsparentid + ", goodspic="
				+ goodspic + "]";
	}

	public String getGoodsparentname() {
		return goodsparentname;
	}

	public void setGoodsparentname(String goodsparentname) {
		this.goodsparentname = goodsparentname;
	}
	
	
	
	
}
