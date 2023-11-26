package com.example.application;

import com.example.service.EagerlyInitializedSingleton;

public class BusinessApplication {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var singleton = EagerlyInitializedSingleton.getInstance();
        // Compiler Error: new EagerlyInitializedSingleton();
	}

}
