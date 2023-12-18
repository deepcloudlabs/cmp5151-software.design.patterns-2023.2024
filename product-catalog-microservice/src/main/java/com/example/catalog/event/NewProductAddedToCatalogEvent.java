package com.example.catalog.event;

public class NewProductAddedToCatalogEvent extends CatalogEvent {
	public NewProductAddedToCatalogEvent(String sku) {
		super(sku, CatalogEventType.NEW_PRODUCT_ADDED);
	}
}
