package com.tu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by tuyongjian on 2018/8/13.
 * 网关服务
 * @EnableZuulProxy 开启网关服务
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class);
    }

    @Bean
    PermisFilter permisFilter(){
        return new PermisFilter();
    }
}
