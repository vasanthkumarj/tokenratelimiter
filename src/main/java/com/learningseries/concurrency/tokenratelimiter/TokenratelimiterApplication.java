package com.learningseries.concurrency.tokenratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TokenratelimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenratelimiterApplication.class, args);
	}

}
