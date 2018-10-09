package com.qf.entity;

public class Address {

	private Integer id;
	
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + "]";
	}
	
	
}
