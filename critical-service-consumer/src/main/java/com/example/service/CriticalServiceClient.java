package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CriticalServiceClient {
	private final ConsumerService consumerService;
	
	public CriticalServiceClient(ConsumerService consumerService) {
		this.consumerService = consumerService;
	}

	//@Scheduled(fixedRate = 100)
	public void callRemoteSystem() {
		var response = consumerService.callService();
		System.err.println("Response is %s".formatted(response)); 
	}
	
	@Scheduled(fixedRate = 5_000)
	public void asyncCallRemoteSystem() {
		consumerService.asyncServiceCall()
		.thenAccept(response ->
		System.err.println("Response is %s".formatted(response)))
		;
	}
}
