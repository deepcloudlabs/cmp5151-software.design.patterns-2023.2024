package com.example.catalog.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.catalog.entity.Product;
import com.example.catalog.entity.ProductType;
import com.example.catalog.service.CatalogService;

@RestController
@RequestScope
@RequestMapping("/catalog")
@Validated
@CrossOrigin
public class CatalogController {
	private final CatalogService catalogService;

	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/products/{sku}")
	public Product findProductBySku(@PathVariable String sku) {
		return catalogService.findBySku(sku);
	}
	
	@GetMapping("/types")
	public List<String> findProductTypes() {
		return catalogService.findAllProductTypes();
	}

	@GetMapping("/types/{type}/products")
	public List<Product> findProductsByType(@PathVariable ProductType type) {
		return catalogService.findProductsByType(type);
	}
	
	@PutMapping("/products/{sku}")
	public Product updateExistingProduct(@PathVariable String sku,@RequestBody Product product) {
		return catalogService.updateProduct(sku,product);
	}
	
	@PostMapping("/products")
	public Product addNewProductToCatalog(@RequestBody Product product) {
		return catalogService.createProduct(product);
	}
	
	@DeleteMapping("/products/{sku}")
	public Product removeProductFromCatalogBySku(@PathVariable String sku) {
		return catalogService.deleteProduct(sku);
	}
}
