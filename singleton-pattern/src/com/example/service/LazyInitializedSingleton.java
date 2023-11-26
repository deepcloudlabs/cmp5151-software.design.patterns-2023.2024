package com.example.service;

public final class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {
		System.err.println("LazyInitializedSingleton() is running.");
	}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
	
	public void fun() {
		System.out.println("Have fun...");
	}

}
