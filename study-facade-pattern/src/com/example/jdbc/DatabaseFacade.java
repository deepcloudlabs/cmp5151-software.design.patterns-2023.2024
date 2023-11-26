package com.example.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade {
	public List<String> getTableNames(String jdbcUrl, String databaseName,String username, String password) throws SQLException {
		var connection = DriverManager.getConnection(jdbcUrl, username, password);
		var metaData = connection.getMetaData();
		var resultSet = metaData.getTables(databaseName, null, null, null);
		var tableNames = new ArrayList<String>();
		while (resultSet.next())
			tableNames.add(resultSet.getString("TABLE_NAME"));
		return tableNames;
	}
}
