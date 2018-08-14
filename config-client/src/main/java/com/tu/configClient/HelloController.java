package com.tu.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tuyongjian on 2018/8/14.
 * 配置中心
 *
 */

@RestController
@RefreshScope
public class HelloController {

    @Value("${tu}")
    String tu;


    @RequestMapping("/tu")
    public String tu() {
        return this.tu;
    }


}
