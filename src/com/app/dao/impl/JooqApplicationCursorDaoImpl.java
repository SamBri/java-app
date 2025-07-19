package com.app.dao.impl;

import static com.app.jooq.tables.ApplicationCursors.APPLICATION_CURSORS;
import static com.app.jooq.tables.ApplicationCursors.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;

import com.app.dao.AbstractApplicationCursorDao;
import com.app.dto.AppCursorDto;
import com.app.jooq.tables.records.ApplicationCursorsRecord;

//Application Cursor Dao
public class JooqApplicationCursorDaoImpl extends AbstractApplicationCursorDao {

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

	public List fetchCursor(String cursorId) {

		DSLContext fetchCursor = DSL.using(getConnection(), SQLDialect.MYSQL);
	     SelectConditionStep<Record> result = fetchCursor.select().from(APPLICATION_CURSORS)
	    		 .where(APPLICATION_CURSORS.CURSOR_ID.eq(cursorId));
		// prepare as list.
		List<AppCursorDto> list = new ArrayList<>(); // diamond operator
		list = result.stream().map((rec) -> {
			AppCursorDto dto = new AppCursorDto();
			dto.setId(rec.get(APPLICATION_CURSORS.ID));
			dto.setName(rec.get(APPLICATION_CURSORS.NAME));
			dto.setNonce(rec.get(APPLICATION_CURSORS.NONCE));
			dto.setPosX(rec.get(APPLICATION_CURSORS.POS_X));
			dto.setPosY(rec.get(APPLICATION_CURSORS.POS_Y));

			return dto;
		}).collect(Collectors.toList());

		return list;

	}

	public List<AppCursorDto> fetchCursors() {

		DSLContext fetchCursor = DSL.using(getConnection(), SQLDialect.MYSQL);
		Result<Record> result = fetchCursor.select().from(APPLICATION_CURSORS).fetch();

		// prepare as list.
		List<AppCursorDto> list = new ArrayList<>(); // diamond operator
		list = result.stream().map((rec) -> {
			AppCursorDto dto = new AppCursorDto();
			dto.setId(rec.get(APPLICATION_CURSORS.ID));
			dto.setName(rec.get(APPLICATION_CURSORS.NAME));
			dto.setNonce(rec.get(APPLICATION_CURSORS.NONCE));
			dto.setPosX(rec.get(APPLICATION_CURSORS.POS_X));
			dto.setPosY(rec.get(APPLICATION_CURSORS.POS_Y));

			return dto;
		}).collect(Collectors.toList());

		return list;

	}

	public int createCursor(AppCursorDto dto) {

		DSLContext createCursor = DSL.using(getConnection(), SQLDialect.MYSQL);
		ApplicationCursorsRecord appCursorRecord = createCursor.newRecord(APPLICATION_CURSORS);
		appCursorRecord.setCursorId(UUID.randomUUID().toString()); // uuid id;
		appCursorRecord.setName(dto.getName());
		appCursorRecord.setNonce(dto.getNonce()); // forget to add nonce, // comment out.
		appCursorRecord.setPosX(dto.getPosX());
		appCursorRecord.setPosY(dto.getPosY());

		int store = 0;
		try {
			store = appCursorRecord.store();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return store;

	}

}
