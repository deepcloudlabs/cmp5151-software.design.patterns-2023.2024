package com.example.random.service.business;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import com.example.random.service.RandomNumberGenerator;

public class StandardRandomNumberGenerator implements RandomNumberGenerator {

	@Override
	public int generate(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	@Override
	public List<Integer> generate(int min, int max, int size) {
		return IntStream.range(0, size)
				  .mapToObj(i -> generate(min,max))
				  .toList();
	}

}
