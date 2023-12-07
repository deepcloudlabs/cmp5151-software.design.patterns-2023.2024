package com.example;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Exercise02 {

	public static void main(String[] args) {
		var numbers = new ArrayDeque<>(Arrays.asList(4,8,15,16,23,42));
        var sum = numbers.stream()
        		         .parallel()
        		         .mapToInt(Integer::intValue).sum();
		System.out.println("sum is %d".formatted(sum));        
	}

}
