package com.example.catalog.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.catalog.entity.Product;
import com.example.catalog.entity.ProductType;
import com.example.catalog.event.NewProductAddedToCatalogEvent;
import com.example.catalog.event.ProductRemovedFromCatalogEvent;
import com.example.catalog.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatalogService {
	private final ProductRepository productRepository;
	private final KafkaTemplate<String,String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	
	public CatalogService(ProductRepository productRepository, KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
		this.productRepository = productRepository;
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}

	public Product findBySku(String sku) {
		return productRepository.findById(sku).orElseThrow(() -> new IllegalArgumentException("Product does not exist in the catalog"));
	}

	public List<String> findAllProductTypes() {
		return Arrays.stream(ProductType.values()).map(ProductType::name).toList();
	}

	public List<Product> findProductsByType(ProductType type) {
		return productRepository.findAllByType(type);
	}

	public Product createProduct(Product product) {
		Product insertedProduct = productRepository.insert(product);
		try {
			var event = new NewProductAddedToCatalogEvent(product.getSku());
			var eventAsString = objectMapper.writeValueAsString(event);
			kafkaTemplate.send("catalog-events", eventAsString);
		}catch (JsonProcessingException e) {
			System.err.println("Error has occured while converting event to json: %s".formatted(e.getMessage()));
			throw new IllegalArgumentException("Cannot convert event to json: %s".formatted(e.getMessage()));
		}
		return insertedProduct;
	}

	public Product updateProduct(String sku, Product product) {
		if (!productRepository.existsById(sku))
			throw new IllegalArgumentException("Product does not exist in the catalog, so we cannot update.");
		return productRepository.save(product);
	}

	public Product deleteProduct(String sku) {
		var product = productRepository.findById(sku).orElseThrow(() -> new IllegalArgumentException("Product does not exist in the catalog, so we cannot delete."));
		productRepository.delete(product);
		try {
			var event = new ProductRemovedFromCatalogEvent(sku);
			var eventAsString = objectMapper.writeValueAsString(event);
			kafkaTemplate.send("catalog-events", eventAsString);
		}catch (JsonProcessingException e) {
			System.err.println("Error has occured while converting event to json: %s".formatted(e.getMessage()));
			throw new IllegalArgumentException("Cannot convert event to json: %s".formatted(e.getMessage()));
		}
		return product;
	}

}
