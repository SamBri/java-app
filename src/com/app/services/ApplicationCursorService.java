package com.app.services;

import java.util.List;

import com.app.dto.AppCursorDto;

public interface ApplicationCursorService {
	
	List<AppCursorDto> fetchCursors();
	
	String createCursor(AppCursorDto dto);

}
