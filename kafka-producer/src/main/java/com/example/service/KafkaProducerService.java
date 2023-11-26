package com.example.service;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.message.Trade;

@Service
public class KafkaProducerService {
	private static final Random random = new SecureRandom();
	@Autowired
	private KafkaTemplate<String, Trade> kafka;

	@Scheduled(fixedRate = 3_000)
	public void sendMessage() {
		Trade trade = new Trade("btc", random.nextDouble() * 100, random.nextDouble() * 10);
		kafka.send("trades", trade.getSymbol(), trade);
	}
}
