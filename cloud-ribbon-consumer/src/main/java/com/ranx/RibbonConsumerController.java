package com.ranx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 调用提供者的 home 方法
 * @author ranx
 * @create 2019-04-07 16:29
 **/
@RestController
public class RibbonConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hello")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }
}
