package com.qf.springboot.springboot_demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @RestController
 *  里面的方法自动加上@Responsebody
 * @Controller
 *
 *
 *
String time = "2018-10-1 00:00:00";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date parse = sdf.parse(time);

//java本身的定时任务
new Timer().schedule(new TimerTask() {
@Override
public void run() {
System.out.println("定时任务体....." + new Date());
}
}, parse,24 * 60 * 60 * 1000);
 *
 */
@RestController
public class MyController {

    @Value("${com.name}")
    private String name;

    @RequestMapping("/hello")
    public String hello() throws ParseException {
        System.out.println("调用了controller" + name);





        return "hello springboot!!";
    }
}
