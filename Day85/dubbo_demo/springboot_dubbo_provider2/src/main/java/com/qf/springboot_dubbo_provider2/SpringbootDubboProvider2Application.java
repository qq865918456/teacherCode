package com.qf.springboot_dubbo_provider2;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan("com.qf.springboot_dubbo_provider2.service")
public class SpringbootDubboProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboProvider2Application.class, args);
	}
}
