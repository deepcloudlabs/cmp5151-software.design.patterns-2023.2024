package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.dto.Trade;

@Service
public class WebSocketTradeService {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@EventListener
	public void listen(Trade trade) {
		messagingTemplate.convertAndSend("/topic/changes", trade);
	}
}
