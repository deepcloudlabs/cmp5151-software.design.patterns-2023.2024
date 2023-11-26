package com.example.service;

public final class DoubleCheckedThreadSafeSingleton {
	private static DoubleCheckedThreadSafeSingleton instance;

	private DoubleCheckedThreadSafeSingleton() {
	}

	public static DoubleCheckedThreadSafeSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckedThreadSafeSingleton();
				}
			}
		}
		return instance;
	}

}
