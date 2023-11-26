package com.example.service;

public class ThreadSafeInnerClassSingleton {
	private ThreadSafeInnerClassSingleton() {
	}

	private static class SingletonHelper {
		private static final ThreadSafeInnerClassSingleton INSTANCE = new ThreadSafeInnerClassSingleton();
	}

	public static ThreadSafeInnerClassSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
