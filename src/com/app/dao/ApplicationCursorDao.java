package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//Application Cursor Dao
public class ApplicationCursorDao {

	private String userName = "root";
	private String password = "";
	private String url = "jdbc:mysql://localhost:3306/java_app";

// make a db connection.
	public Connection getConnection() {

		try (Connection conn = DriverManager.getConnection(url, userName, password)) {
			return conn;
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void fetchCursor(String cursorId) {
		
		getConnection();
		

	}

}
