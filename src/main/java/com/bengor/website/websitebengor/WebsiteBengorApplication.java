package com.bengor.website.websitebengor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.bengor.website.websitebengor"})
public class WebsiteBengorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebsiteBengorApplication.class, args);
	}
}
