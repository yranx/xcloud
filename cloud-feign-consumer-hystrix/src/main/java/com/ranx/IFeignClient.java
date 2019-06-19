package com.ranx;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 指定这个接口所要调用的 提供者服务名称 - eureka-provider
 *
 * 在代码中调用了eureka-provider服务的 / 接口，
 * / 就是调用：服务提供者项目：cloud-eureka-provider，cloud-eureka-provider-2，cloud-eureka-provider-3的home() 方法
 */


@FeignClient(value="eureka-provider",fallbackFactory = HystrixClientFallbackFactory.class)
public interface IFeignClient {

    @GetMapping("/")
    String consumer();
}
