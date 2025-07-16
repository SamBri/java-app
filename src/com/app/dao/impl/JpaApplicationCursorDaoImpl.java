package com.app.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.app.dao.AbstractApplicationCursorDao;
import com.app.dto.AppCursorDto;

//Application Cursor Dao
public class JpaApplicationCursorDaoImpl extends AbstractApplicationCursorDao {

	private String userName = "root";
	private String password = "BlueObjectx1"; // change as you want
	private String url = "jdbc:mysql://localhost:3306/java_app";

// make a db connection.
	public Connection getConnection() {

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			// System.setProperty("javax.net.ssl.keyStore","C:\\ProgramData\\MySQL\\MySQL
			// Server 8.0\\Data\\keystore");
			// System.setProperty("javax.net.ssl.keyStorePassword",password);

			Connection conn = DriverManager.getConnection(url, userName, password);
			return conn;
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void fetchCursor(String cursorId) {

	}

	public List fetchCursors() {

		return null;
	}

	public int createCursor(AppCursorDto dto) {

		return -1;
	}

}
