package com.qf.refrech;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射
 * 什么是反射？ - 反射就是一种在运行时解析对象的技术
 * 		通过反射可以拿到一个对象的属性、方法、构造方法、注解、修饰符.....等成员
 * 
 * 反射的用法：
 * 	1、获得Class对象
 * 		1）类名.class
 * 		2）对象.getClass()
 * 		3）Class.forName("类的全路径")
 * 
 * @author ken
 *
 */
public class MainTest {

	public static void main(String[] args) throws Exception, SecurityException {
		Class c = Dog.class;
		
		Dog dog = new Dog();
		//操作构造方法
		//操作属性
		//dog.name = "旺财";
//		Field field = c.getField("name");
//		field.set(dog, "旺财");
//		
//		Field[] fields = c.getFields();
//		for(Field fd : fields){
//			System.out.println(fd.getName());
//		}
		
		
//		Field[] fields = c.getDeclaredFields();
//		for(Field fd : fields){
//			//授权
//			fd.setAccessible(true);
//			System.out.println(fd.getName());
//		}
		
//		Field field = c.getField("name");
//		int modifier = field.getModifiers();//获得这个属性的修饰符
//		System.out.println(Modifier.isPublic(modifier));
//		System.out.println(Modifier.isStatic(modifier));
//		System.out.println(Modifier.isNative(modifier));
//		System.out.println(Modifier.isFinal(modifier));
		
		
		//操作方法
	}
}

class Dog{
	public String name;
	private Integer age;
}
