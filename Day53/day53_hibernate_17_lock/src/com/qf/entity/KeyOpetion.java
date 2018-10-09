package com.qf.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * kei操作类
 * 
 * @author admin
 *
 */
public class KeyOpetion {

	// Keys用来装key
	public List<String> keys = new ArrayList<String>();

	/**
	 * 创建key
	 * 
	 * @return
	 */
	public String createKey() {
		// 1.创建key
		String key = System.currentTimeMillis() + "";
		
		// 2.服务端存一份
		keys.add(key);
		
		// 3.返回给表单
		return key;
	}
	
	/**
	 * 判断key是否有效
	 * @param key
	 * @return
	 */
	public boolean isToken(String key){
		return keys.contains(key);
	}
	
	/**
	 * 删除key
	 * @param key
	 */
	public void del(String key){
		keys.remove(key);
	}

}
