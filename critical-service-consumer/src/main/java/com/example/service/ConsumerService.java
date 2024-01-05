package com.example.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class ConsumerService {

	//@Retry(name = "critical",fallbackMethod = "callServiceFallback")
	//@RateLimiter(name="critical",fallbackMethod = "callServiceFallback")
	public String callService() {
		try {
			var restTemplate = new RestTemplate();
			return restTemplate.getForEntity("http://localhost:10100/critical/api/v1/values", String.class).getBody();			
		} catch (Exception e) {
			System.err.println("Error: %s".formatted(e.getMessage()));
			throw e;
		}
	}
	
	@TimeLimiter(name="critical")
	public CompletableFuture<String> asyncServiceCall() {
		return CompletableFuture.supplyAsync(() -> {
			try {
				var restTemplate = new RestTemplate();
				return restTemplate.getForEntity("http://localhost:10100/critical/api/v1/values", String.class).getBody();			
			} catch (Exception e) {
				System.err.println("Error: %s".formatted(e.getMessage()));
				throw e;
			}			
		});
	}
	public String callServiceFallback(Exception e) {
		System.err.println("We has a problem houstan: %s".formatted(e.getMessage()));
		return "hello mars!";
	}
}
