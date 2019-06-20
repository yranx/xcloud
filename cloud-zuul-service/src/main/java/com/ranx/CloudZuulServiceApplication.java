package com.ranx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class CloudZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZuulServiceApplication.class, args);
	}

}
