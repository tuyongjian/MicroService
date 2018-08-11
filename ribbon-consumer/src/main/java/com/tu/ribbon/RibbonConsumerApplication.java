package com.tu.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tuyongjian on 2018/8/9.
 * eureka 消费者
 *@EnableEurekaClient 指明是eureka客户端的注解
 * @EnableCircuitBreaker 开启断路器功能
 */
@EnableCircuitBreaker
@SpringBootApplication
@EnableEurekaClient
public class RibbonConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class);
    }

    //RestTemplate可以帮助我们发起一个GET或者POST请求，
    //我们只需要提供一个RestTemplate
    //Bean就可以了，在提供Bean的同时，添加@LoadBalanced注解，表示开启客户端负载均衡。
    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
