package com.ranx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CloudFeignConsumerHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFeignConsumerHystrixApplication.class, args);
	}

}
