package com.example.catalog.consumer.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.catalog.entity.Product;
import com.example.catalog.entity.ProductType;

@Service
public class ConsumerServiceFeignClient {
	private final ProductCatalogService catalogService;

	public ConsumerServiceFeignClient(ProductCatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	@Scheduled(fixedRate = 3_000)
	public void consumeCatalogService() {
		var id = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
		var product = new Product(Integer.toString(id), ProductType.ELECTRONICS, "product name", "product description",2023, 10, new String[] { "" });
		product = catalogService.addProduct(product);
		System.out.println(product);
	}
}
