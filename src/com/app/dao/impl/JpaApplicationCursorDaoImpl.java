package com.app.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.app.dao.AbstractApplicationCursorDao;
import com.app.dto.AppCursorDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//Application Cursor Dao
public class JpaApplicationCursorDaoImpl extends AbstractApplicationCursorDao {

	private String userName = "root";
	private String password = "BlueObjectx1"; // change as you want
	private String url = "jdbc:mysql://localhost:3306/java_app";

	@PersistenceContext
	private EntityManager em;

	public List fetchCursor(String cursorId) {

		return null;

	}

	public List fetchCursors() {

		return null;
	}

	public int createCursor(AppCursorDto dto) {

		return -1;
	}

}
