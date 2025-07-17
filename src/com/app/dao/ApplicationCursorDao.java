package com.app.dao;

import java.util.List;

import com.app.dto.AppCursorDto;



// contract.
public interface ApplicationCursorDao {
	
	public final static int JOOQ = 1;
	public final static int JPA = 2;
	public final static int HIBERNATE = 3;
	public final static int MOET = 4;
	public final static int JDBC = 5;
	
	public void fetchCursor(String cursorId);
	
	int createCursor(AppCursorDto dto);
	
	List fetchCursors();

}
