package com.example.service;

public final class EagerlyInitializedSingleton {
	private static final EagerlyInitializedSingleton instance = new EagerlyInitializedSingleton();

	private EagerlyInitializedSingleton() {
	}

	public static EagerlyInitializedSingleton getInstance() {
		return instance;
	}

}
