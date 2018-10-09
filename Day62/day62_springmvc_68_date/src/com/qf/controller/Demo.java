package com.qf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo {

	public static void main(String[] args) throws Exception {
		String data = "2018-12-12";
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(data));
	}
}
