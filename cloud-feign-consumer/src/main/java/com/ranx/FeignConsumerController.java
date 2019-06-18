package com.ranx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用提供者的 home 方法
 * @author ranx
 * @create 2019-04-07 16:29
 **/
@RestController
public class FeignConsumerController {

    @Autowired
    private IFeignClient feignClient;

    @GetMapping(value = "/hello")
    public String hello() {
        return feignClient.consumer();
    }
}
