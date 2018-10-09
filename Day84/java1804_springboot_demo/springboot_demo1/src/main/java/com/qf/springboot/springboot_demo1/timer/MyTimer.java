package com.qf.springboot.springboot_demo1.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * cron表达式 - x x x x x x x
 * x x x x x x x
 * 秒 分 时 日 月 星期 (年)
 *
 从10月1号开始凌晨发布一个活动 每2个星期重新发布一次 一直发布到12月底
 *
 */
@Component
public class MyTimer {

    /**
     * 定时任务体
     */
    @Scheduled(cron = "0 0 0 1/14 10-12 ? 2018")
    public void taskRun(){
        System.out.println("定时任务已经执行！！！！！！" + new Date());
    }
}
