package com.example.random.service;

import java.util.List;

public interface RandomNumberGenerator {
	int generate(int min,int max);
	List<Integer> generate(int min,int max,int size);
	
}
