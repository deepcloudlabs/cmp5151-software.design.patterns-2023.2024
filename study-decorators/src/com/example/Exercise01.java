package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercise01 {

	public static void main(String[] args) throws Exception {
		var jack = new Employee("11111111110","jack bauer",100_000,"tr1");
		try(
				FileOutputStream fos = new FileOutputStream(new File("c:/tmp","jack.data"));
				ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			oos.writeObject(jack);			
		}
	}

}

record Employee(String identity,String fullname, double salary,String iban) implements Serializable {
	
}