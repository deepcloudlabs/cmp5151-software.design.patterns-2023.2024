package com.example;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Exercise04 {

	public static void main(String[] args) {
		var numbers = new ArrayDeque<>(Arrays.asList(4,8,15,16,23,42));
		var sum = 0;
		for (var number : numbers) { //for-each
			sum += number;			
		}
		System.out.println("sum is %d".formatted(sum));     
	}

}
