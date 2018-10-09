package com.qf.stu.student_demo.service.impl;

import com.qf.stu.student_demo.dao.IStuDao;
import com.qf.stu.student_demo.entity.Student;
import com.qf.stu.student_demo.service.IStuService;
import com.qf.stu.student_demo.util.LockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private IStuDao stuDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private LockUtil lockUtil;

    /**
     * 缓存失效问题
     * 1、批量缓存失效的问题
     * 1）让缓存时间散列
     * 2、单个缓存失效的问题
     *
     * wait
     * notify
     * notifyall
     *
     * 必须执行在同步代码块中
     *
     *
     * @return
     */
    @Override
    public List<Student> queryAll() {

        String uuid = UUID.randomUUID().toString();

        //先查询redis -如果redis有，直接返回，如果没有再查询mysql
        List<Student> stus = (List<Student>) redisTemplate.opsForValue().get("stus");
        if (stus == null) {

            //尝试获得分布式锁
            boolean flag = lockUtil.lock("lock", uuid);
            if (flag) {

                //获得锁对象，进行缓存的重建
                System.out.println("查询了数据库");

                stus = stuDao.queryAll();
                //缓存的重建
                redisTemplate.opsForValue().set("stus", stus);
                redisTemplate.expire("stus", 5, TimeUnit.MINUTES);

                //释放锁资源
                lockUtil.unlock("lock", uuid);

            } else {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return queryAll();
            }
        }

        return stus;
    }

    @Override
    public Student insert(Student student) {
        stuDao.insert(student);
        //删除缓存服务器
        redisTemplate.delete("stus");
        return student;
    }

    @Override
    public Student queryOne(Integer id) {
        return stuDao.queryOne(id);
    }

    @Override
    public int deleteById(Integer id) {
        return stuDao.deleteById(id);
    }


}
