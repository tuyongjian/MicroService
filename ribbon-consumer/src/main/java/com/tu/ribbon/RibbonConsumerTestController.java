package com.tu.ribbon;

import com.tu.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tuyongjian on 2018/8/11.
 */
@RestController
public class RibbonConsumerTestController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloController(){
        return helloService.hello();
    }




}
