package com.tu.provider;

import com.tu.common.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by len on 2018/8/8.
 */
@RestController
public class HelloController{


    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    //使用这个注解可以使服务能够被发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        List<ServiceInstance> instances = client.getInstances("hello-service");
        for (int i = 0; i < instances.size(); i++) {
            logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
        }
        return "Hello World";
    }

    @RequestMapping(value = "sayhello",method = RequestMethod.GET)
    public String sayhello(@RequestParam(value = "name")String name){

        return name;

    }

    @RequestMapping(value = "getbook1",method = RequestMethod.GET)
    public Book getbook1(){

        return new Book("springboot",50,"spring","spring");
    }


    @RequestMapping(value = "getbook2",method = RequestMethod.POST)
    public Book getbook2(@RequestBody Book book){
        return book;
    }
}
