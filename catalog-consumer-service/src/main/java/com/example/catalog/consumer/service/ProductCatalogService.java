package com.example.catalog.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.catalog.entity.Product;

@FeignClient(name = "CATALOG")
public interface ProductCatalogService {
	@PostMapping("/catalog/api/v1/catalog/products")
	public Product addProduct(@RequestBody Product product);
}
