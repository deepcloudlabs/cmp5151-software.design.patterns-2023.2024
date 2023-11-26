package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.message.Trade;

@Service
public class KafkaConsumerService {
	@KafkaListener(topics = "trades")
	public void listen(Trade trade) {
		System.err.println(trade);
	}
}
