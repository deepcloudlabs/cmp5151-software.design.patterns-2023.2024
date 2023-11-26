package com.example.service;

import java.lang.reflect.Constructor;

public class DestroySingletonUsingReflection {

	public static void main(String[] args) throws Exception, SecurityException {
		LazyInitializedSingleton instance = LazyInitializedSingleton.getInstance();
		instance.fun();
		Constructor<?> constructor = LazyInitializedSingleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		constructor.newInstance();
		constructor.newInstance();
		constructor.newInstance();
		constructor.newInstance();
		constructor.newInstance();
		constructor.newInstance();
		constructor.setAccessible(false);
	}

}
