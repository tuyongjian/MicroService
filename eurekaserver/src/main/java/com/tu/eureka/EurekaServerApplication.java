package com.tu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by tuyongjian on 2018/8/7.
 * springCloud 学习eureka服务注册
 *   注册中心启动项
 *  <p>
 *   @EnableEurekaServer 启用服务注册中心注解
 *  </p>
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaServerApplication.class);
    }
}
