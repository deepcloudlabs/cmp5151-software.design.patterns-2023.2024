package com.example;

public class Exercise03 {
	public static void main(String[] args) {
		var beverage = new Milk(new Sugar(new Sugar(new Sugar(new Coffee()))));
		System.out.println("Cost: %f".formatted(beverage.calculatePrice())); 
	}
}

interface Beverage {
	double calculatePrice();
}

class Tea implements Beverage {

	@Override
	public double calculatePrice() {
		return 20;
	}
	
}
class Coffee implements Beverage {
	
	@Override
	public double calculatePrice() {
		return 30;
	}
	
}

abstract class Decorator implements Beverage{
	protected final Beverage beverage;

	public Decorator(Beverage beverage) {
		this.beverage = beverage;
	}
	
}

class Sugar extends Decorator {

	public Sugar(Beverage beverage) {
		super(beverage);
	}

	@Override
	public double calculatePrice() {
		return this.beverage.calculatePrice() + 5;
	}
}

class Milk extends Decorator {
	
	public Milk(Beverage beverage) {
		super(beverage);
	}
	
	@Override
	public double calculatePrice() {
		return this.beverage.calculatePrice() + 15;
	}
}

class CoffeeWithMilk extends Coffee{}
class CoffeeWithMilkAndSugar extends Coffee{}
class CoffeeWithMilkAndSugarAndSugar extends Coffee{}