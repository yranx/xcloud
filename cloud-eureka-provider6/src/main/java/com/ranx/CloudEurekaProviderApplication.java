package com.ranx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@RefreshScope
@SpringBootApplication
@EnableEurekaClient
@RestController
public class CloudEurekaProviderApplication {

	@Value("${server.port}")
	String port;

    @Value("${content}")
    private String content;

	public static void main(String[] args) {
		SpringApplication.run(CloudEurekaProviderApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello world, port: " + port + ",content=" + content;
	}
}
