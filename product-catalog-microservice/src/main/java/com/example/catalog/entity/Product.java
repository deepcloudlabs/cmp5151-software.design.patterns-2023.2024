package com.example.catalog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection="products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "sku")
public class Product {
	@Id
	private String sku;
	private ProductType type;
	private String name;
	private String description;
	private int year;
	private int quantity;
	private String[] photos;
}
