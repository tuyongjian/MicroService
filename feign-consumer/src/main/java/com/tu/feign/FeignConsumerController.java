package com.tu.feign;

import com.tu.common.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tuyongjian on 2018/8/12.
 */
@RestController
public class FeignConsumerController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.hello();
    }


    @RequestMapping("/feignGetBook")
    public Book feignGetBook() {
        return helloService.getbook1();
    }
}