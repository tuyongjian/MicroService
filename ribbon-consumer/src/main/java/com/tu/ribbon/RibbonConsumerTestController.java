package com.tu.ribbon;

import com.tu.common.Book;
import com.tu.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tuyongjian on 2018/8/11.
 *
 * 断路器demo，降级服务测试
 */
@RestController
public class RibbonConsumerTestController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloController(){
        return helloService.hello();
    }


    @RequestMapping(value = "/getbook1test",method = RequestMethod.GET)
    public Book getbook1Controller(){
        return helloService.getbook1test();
    }

}
