package com.example;

@SuppressWarnings("unused")
public class Exercise04 {
	public static void main(String[] args) {
		P a = (P) new BB();	
	}
}

class AA{}
class BB extends AA{}
class CC extends BB{}
class DD implements P {}
interface P {}