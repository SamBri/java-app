package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.UUID;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static com.app.jooq.Tables.*;

import com.app.dto.AppCursorDto;
import com.app.jooq.tables.records.ApplicationCursorsRecord;

//Application Cursor Dao
public class ApplicationCursorDao {

	private String userName = "root";
	private String password = "BlueObjectx1";
	private String url = "jdbc:mysql://localhost:3306/java_app";

// make a db connection.
	public Connection getConnection() {

		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			return conn;
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void fetchCursor(String cursorId) {

		DSLContext fetchCursor = DSL.using(getConnection(), SQLDialect.MYSQL);
		Result<Record> result = fetchCursor.select().from(APPLICATION_CURSORS).fetch();

	}

	public Result<Record> fetchCursors() {

		DSLContext fetchCursor = DSL.using(getConnection(), SQLDialect.MYSQL);
		Result<Record> result = fetchCursor.select().from(APPLICATION_CURSORS).fetch();

		return result;
	}

	public int createCursor(AppCursorDto dto) {

		DSLContext createCursor = DSL.using(getConnection(), SQLDialect.MYSQL);
		ApplicationCursorsRecord appCursorRecord = createCursor.newRecord(APPLICATION_CURSORS);
		appCursorRecord.setCursorId(UUID.randomUUID().toString()); // uuid id;
		appCursorRecord.setName(dto.getName());
		appCursorRecord.setPosX(dto.getPosX());
		appCursorRecord.setPosY(dto.getPosY());

		int store = appCursorRecord.store();
		
		return store;

	}

}
