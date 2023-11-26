package com.example.application;

import java.sql.SQLException;

import com.example.jdbc.DatabaseFacade;

public class DatabaseFacadeApplication {

	public static void main(String[] args) throws SQLException {
		var databaseFacade = new DatabaseFacade();
		databaseFacade.getTableNames("jdbc:mysql://localhost:3306/world", 
				"world", "root", "Secret_123").forEach(System.out::println);

	}

}
