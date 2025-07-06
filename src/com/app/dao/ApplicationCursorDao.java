package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.app.jooq.tables.ApplicationCursors;
import com.app.jooq.tables.records.ApplicationCursorsRecord;

//Application Cursor Dao
public class ApplicationCursorDao {

	private String userName = "root";
	private String password = "BlueObjectx1";
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

	public void fetchCursors(String cursorId) {

		DSLContext fetchCursor = DSL.using(getConnection(), SQLDialect.MYSQL);
		Result<Record> result = fetchCursor.select().from(ApplicationCursors.APPLICATION_CURSORS).fetch();

	}

	public Result<Record> fetchCursors() {

		DSLContext fetchCursor = DSL.using(getConnection(), SQLDialect.MYSQL);
		Result<Record> result = fetchCursor.select().from(ApplicationCursors.APPLICATION_CURSORS).fetch();

		return result;
	}

}
