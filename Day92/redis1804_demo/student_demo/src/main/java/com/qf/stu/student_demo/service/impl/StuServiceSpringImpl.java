package com.qf.stu.student_demo.service.impl;

import com.qf.stu.student_demo.dao.IStuDao;
import com.qf.stu.student_demo.entity.Student;
import com.qf.stu.student_demo.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class StuServiceSpringImpl implements IStuService {


    @Autowired
    private IStuDao stuDao;

    /**
     *  @Cacheable
     *  作用：多作用于查询业务，添加了这个注解的业务方法，会先去缓存服务器查询数据，如果缓存服务器有结果这步调用目标方法
     *  value:表示缓存的前缀名称
     *  key:缓存的动态名称
     *  condition:如果表达式为false，这表示不会调用缓存，直接调用业务方法（无论缓存有没有数据）
     *  unless:如果表达式为true，则不会将业务方法的返回值放缓存中
     *
     *  @CachePut
     *  作用：和@Cacheable基本类似，唯一的区别在于，@CachePut一定会执行业务方法，并且将业务方法的返回值添加到缓存中，多作用于添加的方法
     *
     *  @CacheEvict
     *  作用：会删除指定的缓存
     *
     *
     * @return
     */
    @Override
    @Cacheable(value="cache", key="'stus'")
    public List<Student> queryAll() {
        System.out.println("调用了业务方法！！！！！");
        //先查询redis - 有直接返回 - 则查询数据库并且缓存重建
        List<Student> stus = stuDao.queryAll();
        return stus;
    }


    @Override
    @CachePut(value = "cache", key = "'stu' + #result.id")
    @CacheEvict(value="cache", key = "'stus'")
    public Student insert(Student student) {
        stuDao.insert(student);
        return student;
    }

    @Override
    @Cacheable(value = "cache", key = "'stu' + #id", condition = "#id >= 10", unless = "#result.age >= 18")
    public Student queryOne(Integer id) {
        System.out.println("查询了单个学生：" + id);
        return stuDao.queryOne(id);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value="cache", key = "'stu' + #id"),
            @CacheEvict(value="cache", key = "'stus'")
    })
    public int deleteById(Integer id) {
        return stuDao.deleteById(id);
    }

}
