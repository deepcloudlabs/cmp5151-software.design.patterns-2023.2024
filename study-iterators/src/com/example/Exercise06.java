package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Exercise06 {

	public static void main(String[] args) throws SQLException {
		var jdbcUrl = "jdbc:mysql://localhost:3306/world";
		var username = "root";
		var password = "Secret_123";
		var connection = DriverManager.getConnection(jdbcUrl, username, password);
		var preparedStatement = connection.prepareStatement("select * from country where continent='Asia'");
		var resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) { // iterator pattern implementation
			System.out.println(resultSet.getString("NAME"));
		}
	}

}
