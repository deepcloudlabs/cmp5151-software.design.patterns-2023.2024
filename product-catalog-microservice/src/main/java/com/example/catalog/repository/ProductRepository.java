package com.example.catalog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.catalog.entity.Product;
import com.example.catalog.entity.ProductType;

public interface ProductRepository extends MongoRepository<Product, String>{
	List<Product> findAllByYear(int year);
	List<Product> findAllByYearBetween(int fromYear,int toYear);
	List<Product> findAllByType(ProductType type);
}
