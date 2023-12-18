package com.example.catalog.event;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class CatalogEvent {
	private String eventId = UUID.randomUUID().toString();
	private ZonedDateTime eventTime = ZonedDateTime.now();
	private final String sku;
	private final CatalogEventType eventType;
}
