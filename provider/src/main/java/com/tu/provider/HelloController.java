package com.tu.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by len on 2018/8/8.
 */
@RestController
public class HelloController{


        private final Logger logger = LoggerFactory.getLogger(HelloController.class);
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
}
