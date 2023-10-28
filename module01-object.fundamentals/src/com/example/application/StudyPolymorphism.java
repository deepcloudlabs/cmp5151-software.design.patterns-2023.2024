package com.example.application;

import java.util.concurrent.ThreadLocalRandom;

public class StudyPolymorphism {

	public static void main(String[] args) {
		Shape s;
		if (ThreadLocalRandom.current().nextBoolean())
			s = new Square(4);
		else
			s = new Cube(4);
		System.out.println(s.getClass().getName());
		System.out.println(s.area());
	}

}

abstract class Shape {
	abstract public double area();

	abstract public double circumference();
}

class Square extends Shape {
	protected double edge;

	public Square(double edge) {
		this.edge = edge;
	}

	public double getEdge() {
		return edge;
	}

	public double area() {
		System.out.println("Square::area");
		return this.edge * this.edge;
	}

	public double circumference() {
		return 4.0 * this.edge;
	}
}

class Cube extends Shape {
	protected double edge;

	public Cube(double edge) {
		this.edge = edge;
	}

	public double area() {
		System.out.println("Cube::area");
		return 6.0 * this.edge * this.edge;
	}

	public double circumference() {
		return 12.0 * this.edge;
	}
}

class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public double circumference() {
		return 2.0 * Math.PI * this.radius;
	}
}