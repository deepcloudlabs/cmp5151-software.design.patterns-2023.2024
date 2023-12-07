package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exercise02 {

	public static void main(String[] args) throws Exception {
		try(
				FileInputStream fis = new FileInputStream(new File("c:/tmp","jack.data"));
				ObjectInputStream ois = new ObjectInputStream(fis);
		){
			var jack = ois.readObject();			
			System.out.println(jack);
		}
	}

}