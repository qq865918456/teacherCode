package com.qf.shiro.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//@InitBinder
public class BaseController {

    //只处理没有权限的异常
    @ExceptionHandler(UnauthorizedException.class)
    public String noPowerException(UnauthorizedException e){
        return "nopower";
    }

}
