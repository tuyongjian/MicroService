package com.tu.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by tuyongjian on 2018/8/14.
 * springCloud 配置中心服务端
 * @EnableConfigServer 开启服务配置
 * @EnableDiscoveryClient 开启注册服务
 */

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class);
    }
}
