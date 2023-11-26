package com.example.hr.adapter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.hr.application.business.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventPublisherRabbitMQAdapter 
          implements EventPublisher<EmployeeEvent> {
	private final RabbitTemplate rabbitTemplate;
	private final ObjectMapper objectMapper;
	private final String exchangeName;

	public EventPublisherRabbitMQAdapter(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper,
			@Value("${hrExchangeName}") String exchangeName) {
		this.rabbitTemplate = rabbitTemplate;
		this.objectMapper = objectMapper;
		this.exchangeName = exchangeName;
	}

	@Override
	public void publish(EmployeeEvent event) {
		try {
			var eventAsJson = objectMapper.writeValueAsString(event);
			rabbitTemplate.convertAndSend(exchangeName,null, eventAsJson);
		} catch (JsonProcessingException e) {
			System.err.println("Error whle converting event to json: %s".formatted(e.getMessage()));
		}

	}

}
