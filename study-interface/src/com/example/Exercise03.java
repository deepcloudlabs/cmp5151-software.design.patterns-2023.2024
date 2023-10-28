package com.example;

import java.util.List;

public class Exercise03 {

	public static void main(String[] args) {
		List<Animal> zooAnimals = List.of(new Spider(),new Cat("Garfield"),new Cat(),new Spider());
		for (var animal : zooAnimals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet pet)
				pet.play();
		}
		
	}

}

interface Pet {
	void play();

	void setName(String name);

	String getName();
}

abstract class Animal {
	private int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}

	public void walk() {
		System.out.println("Animal with %d legs is walking now...".formatted(legs));
	}

	abstract public void eat();
}

class Spider extends Animal {

	public Spider() {
		super(8);
	}

	@Override
	public void eat() {
		System.out.println("Spider is eating now...");
	}
}

class Cat extends Animal implements Pet {
	private String name = "Tekir";

	public Cat() {
		super(4);
	}

	public Cat(String name) {
		super(4);
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println("%s is playing now...".formatted(name));
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void eat() {
		System.out.println("%s is eating now...".formatted(name));
	}
}