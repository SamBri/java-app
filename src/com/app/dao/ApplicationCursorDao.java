package com.app.dao;

import java.util.List;

import com.app.dto.AppCursorDto;



// contract.
public interface ApplicationCursorDao {
	
	public void fetchCursor(String cursorId);
	
	int createCursor(AppCursorDto dto);
	
	List fetchCursors();

}
