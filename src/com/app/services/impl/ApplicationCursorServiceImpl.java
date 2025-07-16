package com.app.services.impl;

import static com.app.jooq.tables.ApplicationCursors.APPLICATION_CURSORS;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import com.app.dao.impl.jooq.ApplicationCursorDaoImpl;
import com.app.dto.AppCursorDto;

public class ApplicationCursorServiceImpl {

	// fetch all app cursors.
	public  List<AppCursorDto> fetchCursors() {

		Result<Record> cursors = new ApplicationCursorDaoImpl().fetchCursors();

		final List<AppCursorDto> list = new ArrayList<>();

		cursors.forEach((e) -> {
			AppCursorDto dto = new AppCursorDto();
			dto.setId(e.get(APPLICATION_CURSORS.ID));
			dto.setName(e.get(APPLICATION_CURSORS.NAME));
			dto.setNonce(e.get(APPLICATION_CURSORS.NONCE));
			dto.setPosX(e.get(APPLICATION_CURSORS.POS_X));
			dto.setPosY(e.get(APPLICATION_CURSORS.POS_Y));

			list.add(dto);
		});

		return list;

	}

	// create cursor
	public  String createCursor(AppCursorDto dto) {

		if (new ApplicationCursorDaoImpl().createCursor(dto) == 1) {
			return "created";
		}

		return "failed";

	}

}
