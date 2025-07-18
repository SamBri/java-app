package com.app.services;

import java.util.List;

import com.app.dto.AppCursorDto;

public interface ApplicationCursorService {
	
	List fetchCursors(); // generic wildcard bound
	
	String createCursor(AppCursorDto dto);
	
	List fetchCursor(String cursorId);

}
