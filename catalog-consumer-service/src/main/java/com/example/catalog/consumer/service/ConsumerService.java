package com.example.catalog.consumer.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.catalog.entity.Product;
import com.example.catalog.entity.ProductType;

import jakarta.annotation.PostConstruct;

//@Service
public class ConsumerService {
	private final DiscoveryClient discoveryClient;
	private List<ServiceInstance> instances = List.of();
	private final AtomicInteger counter = new AtomicInteger();

	public ConsumerService(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@PostConstruct
	@Scheduled(fixedRate = 10_000)
	public void loadInstancesFromRegistryServer() {
		instances = discoveryClient.getInstances("CATALOG");
	}

	@Scheduled(fixedRate = 3_000)
	public void consumeCatalogService() {
		var restTemplate = new RestTemplate();
		var instance = this.instances.get(counter.getAndIncrement() % this.instances.size());
		var id = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
		var product = new Product(Integer.toString(id), ProductType.ELECTRONICS, "product name", "product description",
				2023, 10, new String[] { "" });
		try {
			var response = restTemplate.postForEntity(
					"http://%s:%d/catalog/api/v1/catalog/products".formatted(instance.getHost(), instance.getPort()),
					product, Product.class).getBody();
			System.out.println(response);
		} catch (Exception e) {
			instances = discoveryClient.getInstances("CATALOG");
		}
	}
}
