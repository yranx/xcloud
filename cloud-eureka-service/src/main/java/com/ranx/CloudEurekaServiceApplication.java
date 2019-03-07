package com.ranx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //申明此处为服务注册中心
public class CloudEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServiceApplication.class, args);
    }

}
