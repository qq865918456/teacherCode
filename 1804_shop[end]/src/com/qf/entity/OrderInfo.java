package com.qf.entity;

import java.util.Date;

public class OrderInfo {

	private Integer id;
	
	private String o_sendtype;
	
	private String o_paytype;
	
	private Integer o_paycount;
	
	private Date o_orderdate;
	
	private Integer userid;
	
	private String o_shperson;
	
	private String o_shphone;
	
	private String o_shaddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getO_sendtype() {
		return o_sendtype;
	}

	public void setO_sendtype(String o_sendtype) {
		this.o_sendtype = o_sendtype;
	}

	public String getO_paytype() {
		return o_paytype;
	}

	public void setO_paytype(String o_paytype) {
		this.o_paytype = o_paytype;
	}

	public Integer getO_paycount() {
		return o_paycount;
	}

	public void setO_paycount(Integer o_paycount) {
		this.o_paycount = o_paycount;
	}

	public Date getO_orderdate() {
		return o_orderdate;
	}

	public void setO_orderdate(Date o_orderdate) {
		this.o_orderdate = o_orderdate;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getO_shperson() {
		return o_shperson;
	}

	public void setO_shperson(String o_shperson) {
		this.o_shperson = o_shperson;
	}

	public String getO_shphone() {
		return o_shphone;
	}

	public void setO_shphone(String o_shphone) {
		this.o_shphone = o_shphone;
	}

	public String getO_shaddress() {
		return o_shaddress;
	}

	public void setO_shaddress(String o_shaddress) {
		this.o_shaddress = o_shaddress;
	}
	
}
