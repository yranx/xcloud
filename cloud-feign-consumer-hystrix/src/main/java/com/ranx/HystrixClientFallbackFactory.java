package com.ranx;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author ranx
 * @create 2019-06-18 19:41
 **/
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<IFeignClient>{
    @Override
    public IFeignClient create(Throwable throwable) {
        return () -> "feign + hystrix,提供者服务挂了";
    }
}
