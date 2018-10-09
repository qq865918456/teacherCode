package com.qf.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/toindex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username, String password){
        System.out.println("登录的用户名：" + username + " 密码为:" + password);

        //shiro登录
       Subject subject = SecurityUtils.getSubject();
       if(!subject.isAuthenticated()){
           //登录
           UsernamePasswordToken token = new UsernamePasswordToken(username, password);
           try{
               subject.login(token);
           } catch (Exception e){
               return "redirect:/index/tologin";
           }
       }

        return "index";
    }

}
