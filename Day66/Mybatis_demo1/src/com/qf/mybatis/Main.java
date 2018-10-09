package com.qf.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {

	/**
	 * 测试Mybatis
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//1、创建一个Mybatis工厂构建器（构建者设计模式）
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//2、通过构建器创建Session工厂 - 参数：表示mybatis的核心配置文件
		//1)手动获得classpath路径 Main.class.getResource("/").getPath();
		//2)使用mybatis提供的一个Resources工具方法获得配置文件
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = builder.build(in);
		
		//3、通过SqlSessionFactory获得SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		
		
		
		//4、通过session加载映射接口
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		//5、调用方法
		
		//执行queryById
//		User user = mapper.queryById(1);
//		System.out.println("查询结果：" + user);
		
		
		//执行insertUser
//		User user = new User();
//		user.setName("小明");
//		user.setAge(16);
//		int result = mapper.insertUser(user);
//		System.out.println("插入用户信息：" + result);
		
		//执行修改updateUser
//		User user = new User();
//		user.setId(1);
//		user.setName("小王八");
//		user.setAge(1000);
//		int result = mapper.updateUser(user);
//		System.out.println("修改用户信息：" + result);
		
		
		//执行删除
//		int result = mapper.deleteById(1);
//		System.out.println("删除用户信息：" + result);
		
		
		//查询全部
		List<User> users = mapper.queryAll();
		System.out.println("查询所有用户信息：" + users);
		
		//6、关闭session
		session.commit();//如果是增删改必须提交事务
		session.close();
	}
}
