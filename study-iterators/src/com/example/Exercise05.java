package com.example;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exercise05 {
	public static void main(String[] args) {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of("c:/", "tmp"))) {
			for (var entry : directoryStream) {
				System.out.println(entry.getFileName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
