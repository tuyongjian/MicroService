package com.tu.feign;

import com.tu.common.Book;
import org.springframework.stereotype.Component;

/**
 * Created by tuyongjian on 2018/8/12.
 * feign降级服务的类
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error------test";
    }

    @Override
    public Book getbook1() {
        return new Book("111",1,"11","11");
    }
}
