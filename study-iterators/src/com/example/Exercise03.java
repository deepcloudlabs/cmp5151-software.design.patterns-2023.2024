package com.example;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Exercise03 {
	public static void main(String[] args) {
		var numbers = new ArrayDeque<>(Arrays.asList(4,8,15,16,23,42));
		var spliterator = numbers.spliterator();
		System.out.println(spliterator.estimateSize());
		var left = spliterator.trySplit();
		System.out.println(left.estimateSize());
		System.out.println(spliterator.estimateSize());
		left.forEachRemaining(System.out::println);
		spliterator.forEachRemaining(System.out::println);
	}
}
