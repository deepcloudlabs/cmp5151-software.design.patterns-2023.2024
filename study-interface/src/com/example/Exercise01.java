package com.example;

import java.util.List;

@SuppressWarnings("unused")
public class Exercise01 {

	public static void main(String[] args) {
		Flyable flyingObject = new AirPlane();
		List<Flyable> flyables = List.of(new Bird(), new Ufo(), new Superman());
		for (Flyable flyable : flyables)
			flyable.fly();
	}

}

abstract class Flyable {
	abstract public void fly();
}

class Bird extends Flyable {

	@Override
	public void fly() {
		System.out.println("Bird is flying now...");
	}

}

class AirPlane extends Flyable {
	public void fly() {
		System.out.println("AirPlane is flying now...");
	}
}

class Ufo extends Flyable {
	public void fly() {
		System.out.println("Ufo is flying now...");
	}
}

class Superman extends Flyable {
	public void fly() {
		System.out.println("Superman is flying now...");
	}
}