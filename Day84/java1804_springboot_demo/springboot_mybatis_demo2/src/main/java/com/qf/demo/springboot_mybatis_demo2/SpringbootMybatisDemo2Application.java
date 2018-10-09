package com.qf.demo.springboot_mybatis_demo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 默认>约定>配置>编码
 *
 * Springboot整合Mybatis：
 * 步骤：
 * 1、准备好spring+springmvc(实体类、映射接口、映射文件)
 * 2、引入mybatis和springboot的整合依赖包
		 <dependency>
		 <groupId>org.mybatis.spring.boot</groupId>
		 <artifactId>mybatis-spring-boot-starter</artifactId>
		 <version>1.3.1</version>
		 </dependency>
 * 3、配置application.yml(数据源、映射文件的扫描、实体类别名的扫描)
 * 4、在映射接口上添加@Mapper注解(或者@MapperScan注解扫描)
 * 5、直接在Service层注入Dao层对象即可
 *
 *
 * 回顾Spring整合Mybatis：
 * 1、导包
 * 	Mybatis.jar
 * 	Mybatis-spring.jar
 * 	mysql-connection.jar
 *
 * 2、配置applicationContext.xml
 * 	写好映射接口、映射文件
 * 	1) 配置dataSource - 数据源（数据库的用户名、密码、url、驱动、连接池、连接池相关配置....）
 * 	2) 配置sqlSessionFactoryBean
 * 		引入dataSource
 * 		扫描映射文件xxxMapper.xml
 * 		引入Mybatis的核心配置文件mybatis-config.xml
 * 	3) 扫描mybatis的映射接口 <mybatis:scan package="xxx.xxx.xx.dao"/></mybatis:scan>
 * 	4) 在service层注入映射接口
 *
 */
@SpringBootApplication
@MapperScan("com.qf.demo.springboot_mybatis_demo2.dao")
@EnableTransactionManagement
public class SpringbootMybatisDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDemo2Application.class, args);
	}
}
