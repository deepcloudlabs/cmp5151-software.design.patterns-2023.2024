package com.example.application;

public class StudyString {

	public static void main(String[] args) {
		// object pooling/caching
		String name1 = "jack";
		String name2 = new String("jack");
		String name3 = "jack";
		System.out.println(name1 == name2);
		System.out.println(name1 == name3);

	}

}
