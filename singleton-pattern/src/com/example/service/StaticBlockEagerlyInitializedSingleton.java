package com.example.service;

public final class StaticBlockEagerlyInitializedSingleton {
	private static final StaticBlockEagerlyInitializedSingleton instance;

	static {
		// provides option for exception handling
		instance = new StaticBlockEagerlyInitializedSingleton();
	}

	private StaticBlockEagerlyInitializedSingleton() {
	}

	public static StaticBlockEagerlyInitializedSingleton getInstance() {
		return instance;
	}

}
