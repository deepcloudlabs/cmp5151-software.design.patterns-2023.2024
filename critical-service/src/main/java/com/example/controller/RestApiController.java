package com.example.controller;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/values")
@RequestScope
@CrossOrigin
public class RestApiController {

	@GetMapping
	public String getValue() {
		try {
			TimeUnit.SECONDS.sleep(ThreadLocalRandom.current()
					         .nextInt(0,6));
		} catch (InterruptedException e) {
		}
		return ThreadLocalRandom.current()
				         .ints(1,26)
				         .map(i -> (char)('A' + i))
				         .limit(10)
				         .boxed()
				         .map(i -> i.toString())
				         .collect(Collectors.joining());
	}
}
