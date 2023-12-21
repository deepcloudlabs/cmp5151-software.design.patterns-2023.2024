package com.example.catalog.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.catalog.consumer.service")
public class CatalogConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogConsumerServiceApplication.class, args);
	}

}
