package com.qf.servlet;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Demo {

	public void add() {
		System.out.println("Demo.add()");
	}

	public int add(Integer x, Integer y) {
		return x + y;
	}

	public static void main(String[] args) throws Exception, IllegalAccessException {

		// 加载驱动
		Class<?> classes = Class.forName("com.qf.servlet.Demo");

		// 1.实例化对象
		Object demo = classes.newInstance();

		// 2.得到方法对象
		// Method method = classes.getMethod("add"); // 调用无惨
		Method method = classes.getMethod("add", Integer.class, Integer.class); // 调用有参

		// 3.调用
		Object result = method.invoke(demo, 11, 12);

		System.out.println("方法的返回值：" + result);

	}

	@Test
	public void testAction() {
		String name = "forward:ok.jsp";
		String[] split = name.split(":");
		Map<String, String> map = new HashMap<String, String>();
		map.put(split[0], split[1]);
		System.out.println(map);
	}
}
