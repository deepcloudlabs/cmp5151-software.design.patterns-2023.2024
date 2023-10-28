package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberGenerator;

public class StandardLotteryService implements LotteryService {
	private RandomNumberGenerator randomNumberGenerator;
	
	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		System.out.println(randomNumberGenerator.getClass());
		this.randomNumberGenerator = randomNumberGenerator;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return IntStream.generate(() -> randomNumberGenerator.generate(0, max))
				        .distinct()
				        .limit(size)
				        .sorted()
				        .boxed()
				        .toList();
	}

	@Override
	public List<List<Integer>> draw(int max, int size, int column) {
		return IntStream.range(0, column)
				.mapToObj(i -> draw(max,size))
				.toList();
	}

}
