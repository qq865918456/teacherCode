package com.qf.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.qf.entity.User;

public interface IUserMapper {

	User queryUserById(Integer id);
	
//	List<User> queryUserByParams(@Param("name") String name, @Param("age") int age);
//	List<User> queryUserByParams(Map<String, Object> maps);
//	List<User> queryUserByParams(User user);
//	List<User> queryUserByParams(@Param("user1") User user1, @Param("user2") User user2);
//	List<User> queryLikeByName(String name);
	
	//分页方式1-直接传入limit后面的参数 - 缺点封装性很差
//	List<User> queryAll(@Param("a") int x, @Param("b") int y);
	
	//分页方法2-RowBounds - 缺点如果查询的数量级很大，先将所有结果集全部查出来，再对结果集进行分页过滤
//	List<User> queryAll2(RowBounds rowBounds);
	
	//分页方法3-分页插件
	
	
	//主键回填
//	int insertUser(User user);
//	
//	int insertUser2(Map<String, Object> map);
	
	
	User queryById(@Param("id")Integer id, @Param("columns") String columns);
}
