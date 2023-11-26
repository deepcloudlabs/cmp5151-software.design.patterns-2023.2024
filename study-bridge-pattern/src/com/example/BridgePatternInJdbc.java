package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BridgePatternInJdbc {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Secret_123");
		// com.mysql.cj.jdbc.ConnectionImpl
		System.out.println(connection.getClass());
		PreparedStatement statement = connection.prepareStatement("select distinct continent from country");
		// com.mysql.cj.jdbc.ClientPreparedStatement
		System.out.println(statement.getClass());
		ResultSet resultSet = statement.executeQuery();
		// com.mysql.cj.jdbc.result.ResultSetImpl
		System.out.println(resultSet.getClass());
		
	}

}
