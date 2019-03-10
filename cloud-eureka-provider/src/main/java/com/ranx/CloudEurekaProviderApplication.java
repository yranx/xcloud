package com.ranx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class CloudEurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaProviderApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello world";
	}
}
