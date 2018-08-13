package com.tu.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tu.common.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tuyongjian on 2018/8/11.
 * 断路器demo，降级服务测试
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String hello(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        return responseEntity.getBody();
    }



    public String error(){
        return "error";
    }


    @HystrixCommand(fallbackMethod = "error1",ignoreExceptions = Exception.class)
    public Book getbook1test() {
        int i = 1 / 0;
        return restTemplate.getForObject("http://HELLO-SERVICE/getbook1", Book.class);
    }

    public Book error1(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return new Book("百年孤独", 33, "马尔克斯", "人民文学出版社");
    }
}
