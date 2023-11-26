package com.example.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.dto.Trade;

@Service
public class TradeLogService {


	@EventListener
	public void listen(Trade trade) {
		System.err.println("An event has occured: "+trade);
	}
}
