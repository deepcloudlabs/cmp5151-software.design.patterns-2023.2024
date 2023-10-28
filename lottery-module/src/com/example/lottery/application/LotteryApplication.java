package com.example.lottery.application;

import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.RandomNumberGenerator;

public class LotteryApplication {

	public static void main(String[] args) {
		StandardLotteryService lotteryService = new StandardLotteryService();
		ServiceLoader<RandomNumberGenerator> services = ServiceLoader.load(RandomNumberGenerator.class);
		var randomNumberGenerator = services.findFirst().get();
		lotteryService.setRandomNumberGenerator(randomNumberGenerator);
		System.out.println(lotteryService.draw(60, 8));

	}

}
