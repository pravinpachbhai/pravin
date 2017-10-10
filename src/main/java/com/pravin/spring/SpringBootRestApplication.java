package com.pravin.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

//http://localhost:8080/rest/swagger-ui.html

/**
 * 
 * @author Pravin Pachbhai
 * 
 */

@SpringBootApplication
@ComponentScan({"com.pravin"})
public class SpringBootRestApplication extends SpringBootServletInitializer {

	private static Class<SpringBootRestApplication> application = SpringBootRestApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(application);
	}
}
