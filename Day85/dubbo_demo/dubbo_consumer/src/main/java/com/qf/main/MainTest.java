package com.qf.main;

import com.qf.service.IStuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-*.xml")
public class MainTest {

    @Autowired
    private IStuService iStuService;

    @Test
    public void test(){
        String result = iStuService.hello(10);
        System.out.println("服务消费者获得的返回值：" + result);

        while (true){

        }
    }
}
