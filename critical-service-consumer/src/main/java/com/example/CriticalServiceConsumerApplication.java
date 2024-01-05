package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CriticalServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriticalServiceConsumerApplication.class, args);
	}

}
