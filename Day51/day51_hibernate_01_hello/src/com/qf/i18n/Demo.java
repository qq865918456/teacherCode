package com.qf.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo {

	public static void main(String[] args) {
		
		
		// 返回所有已安装语言环境的数组 
//		Locale[] locales = Locale.getAvailableLocales();
//		for (Locale locale : locales) {
//			System.out.println("国家:"+locale.getDisplayCountry()+",代号："+locale.getCountry());
//			System.out.println("语言:"+locale.getDisplayLanguage()+",代号:"+locale.getLanguage());
//		}
		
		// 中国：zh_CN
		// 美国: en_US
		// username 姓名
		
		// ResourceBundle实现国际化
		Locale locale = new Locale("en", "US");
		ResourceBundle bundle = ResourceBundle.getBundle("resource",locale);
		
		// 根据key获取value
		String value = bundle.getString("name");
		
		System.out.println(value);
		
	}
}
