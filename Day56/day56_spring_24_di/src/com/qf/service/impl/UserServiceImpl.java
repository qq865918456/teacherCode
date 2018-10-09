/**
 * 
 */
package com.qf.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

import com.qf.dao.IUserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.service.IUserService;

/**
 * @author admin
 *
 */
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;// 依赖了Spring容器
	
	private String name; // 通过Sprig给值
	
	private Double price; // double类型的值,帮我们做了类型转换
	
	private List<String> list; // 接收list
	
	private Integer[] ids; // 接收数组
	
	private Map<String, Object> map;
	
//	private Properties properties;
	
	@Override
	public void info() {
		System.out.println("UserServiceImpl.info()");
		System.out.println("name:"+name);
		System.out.println("price:"+price);
		System.out.println("list:"+list);
		System.out.println("ids:"+Arrays.toString(ids));
		System.out.println("map:"+map);
		getUserDao().info();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
