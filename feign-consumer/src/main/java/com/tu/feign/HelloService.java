package com.tu.feign;

import com.tu.common.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tuyongjian on 2018/8/12.
 * hello-service 是服务提供者是provoder 的项目spring.application.name
 * hello 是provider提供的一个方法
 * getbook1 也是provider提供的一个方法
 *
 * 这里可以和ribbon-consumer 的调用方法进行对比分析
 *
 * feign怎么使用降级服务呢,可以新建一个类作为降级服务的类
 */
@FeignClient(value = "hello-service",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/getbook1")
    Book getbook1();


}
