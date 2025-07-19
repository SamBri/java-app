package com.app.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.app.dao.AbstractApplicationCursorDao;
import com.app.dto.AppCursorDto;

//Application Cursor Dao
//public class ApplicationCursorDaoImpl extends AbstractApplicationCursorDao {
public class JdbcApplicationCursorDaoImpl extends AbstractApplicationCursorDao {

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

	// generics * type safety.
	public List<AppCursorDto> fetchCursor(String cursorId) {

		String fetchCursorQueryTxtBlk = """
				SELECT * FROM application_cursors WHERE cursor_id = {cursor_id};
				""".replace("{cursor_id}", "'"+cursorId+"'");

		List<AppCursorDto> cursors = null;
		try (Connection createCursorConn = getConnection()) {

			Statement stmt = createCursorConn.createStatement();
			ResultSet rs = stmt.executeQuery(fetchCursorQueryTxtBlk);

			cursors = new ArrayList<>();

			while (rs.next()) {

				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nonce = rs.getString("nonce");
				cursorId = rs.getString("cursor_id");
				Integer posX = rs.getInt("pos_x"); // autoboxing.
				Integer posY = rs.getInt("pos_y"); // autoboxing.

				cursors.add(new AppCursorDto(id, name, posX, posY, nonce, cursorId));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cursors;

	}

	// generics * type safety.
	public List<AppCursorDto> fetchCursors() {

		String fetchCursorsQueryTxtBlk = """
				SELECT * FROM application_cursors;
				""";

		List<AppCursorDto> cursors = null;
		try (Connection createCursorConn = getConnection()) {

			Statement stmt = createCursorConn.createStatement();
			ResultSet rs = stmt.executeQuery(fetchCursorsQueryTxtBlk);

			cursors = new ArrayList<>();
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nonce = rs.getString("nonce");
				String cursorId = rs.getString("cursor_id");
				Integer posX = rs.getInt("pos_x"); // autoboxing.
				Integer posY = rs.getInt("pos_y"); // autoboxing.

				cursors.add(new AppCursorDto(id, name, posX, posY, nonce, cursorId));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cursors;
	}

	public int createCursor(AppCursorDto dto) {

		// query.
//		String createCursorQuery = "INSERT INTO `java_app`.`application_cursors`\r\n"
//				+ "(`id`,\r\n"
//				+ "`pos_x`,\r\n"
//				+ "`pos_y`,\r\n"
//				+ "`nonce`,\r\n"
//				+ "`cursor_id`,\r\n"
//				+ "`name`)\r\n"
//				+ "VALUES\r\n"
//				+ "(<{id: }>,\r\n"
//				+ "<{pos_x: }>,\r\n"
//				+ "<{pos_y: }>,\r\n"
//				+ "<{nonce: }>,\r\n"
//				+ "<{cursor_id: }>,\r\n"
//				+ "<{name: }>);";

		String createCursorQueryTxtBlk = """
				INSERT INTO application_cursors
				(pos_x,
				pos_y,
				nonce,
				cursor_id,
				name)
				VALUES
				({pos_x},
				{pos_y},
				{nonce},
				{cursor_id},
				{name});
				""";

		createCursorQueryTxtBlk = createCursorQueryTxtBlk.replace("{pos_x}", String.valueOf(dto.getPosX()))
				.replace("{pos_y}", String.valueOf(dto.getPosY())).replace("{nonce}", "'"+dto.getNonce()+"'")
				.replace("{cursor_id}", "'"+UUID.randomUUID().toString()+"'").replace("{name}", "'"+dto.getName()+"'");

		int q = 0;
		try (Connection createCursorConn = getConnection()) {

			Statement stmt = createCursorConn.createStatement();
			q = stmt.executeUpdate(createCursorQueryTxtBlk);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return q;
	}

}
