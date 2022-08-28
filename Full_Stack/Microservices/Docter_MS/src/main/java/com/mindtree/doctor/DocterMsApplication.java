package com.mindtree.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class DocterMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocterMsApplication.class, args);
	}
	@Bean
	@LoadBalanced
	RestTemplate restTemp() {
		return new  RestTemplate();
	}

}
