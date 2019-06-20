package com.ranx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CloudConfigClientApplication {

    @Value("${content}")
    private String content;

    @RequestMapping("/")
    public String home() {
        return "Content:" + content;
    }
	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}

}
