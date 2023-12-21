package com.example.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "sku")
public class Product {
	private String sku;
	private ProductType type;
	private String name;
	private String description;
	private int year;
	private int quantity;
	private String[] photos;
}
