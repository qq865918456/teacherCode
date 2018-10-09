package com.qf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 2个元注解
 * 什么是元注解：注解注解的注解
 * @Retention：表示当前注解的声明周期范围
 * 	RetentionPolicy.SOURCE：表示当前被修饰的注解只能存活在源码中
 *  RetentionPolicy.CLASS：表示当前被修饰的注解只能存活在字节码文件中
 *  RetentionPolicy.RUNTIME：表示当前被修饰的注解只能在运行时存活，通常和反射结合使用
 * @Target：表示该注解的作用范围
 * 	ElementType.ANNOTATION_TYPE：可以注解注解
 * 	ElementType.CONSTRUCTOR：当前注解可以注解构造方法
 * 	ElementType.FIELD：注解成员变量
 * 	ElementType.LOCAL_VARIABLE：注解局部变量
 * 	ElementType.METHOD：注解方法
 * 	ElementType.PACKAGE：注解包
 * 	ElementType.PARAMETER：注解方法参数
 * 	ElementType.TYPE：注解类、接口、枚举类
 * @author ken
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {

	//定义方法
//	String name() default "";
//	int age() default 0;
//	int value();
//	String[] love();
}
