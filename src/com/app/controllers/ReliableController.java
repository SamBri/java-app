package com.app.controllers;

import org.jooq.Result;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jooq.Record;

import com.app.dao.ApplicationCursorDao;


public class ReliableController {

	// fetch all app cursors.
	public List<?> fetchCursors() {

		Result<Record> cursors = new ApplicationCursorDao().fetchCursors();

		return cursors;

	}

}
