package com.ranx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class CloudZuulFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZuulFilterApplication.class, args);
	}

	@Bean
    public TokenFilter tokenFilter() {
	    return new TokenFilter();
    }

    @Bean
    public PasswordFilter passwordFilter() {
        return new PasswordFilter();
    }
}
