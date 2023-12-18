package com.example.catalog.event;

public class ProductRemovedFromCatalogEvent extends CatalogEvent {
	public ProductRemovedFromCatalogEvent(String sku) {
		super(sku, CatalogEventType.PRODUCT_REMOVED);
	}
}
