package com.app.controllers;

import org.jooq.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jooq.Record;

import com.app.dao.ApplicationCursorDao;

@RestController
@RequestMapping("/reliable")
@CrossOrigin(origins = "*") // enable cross origin on the controller level for all origins
//@Slf4j
public class ReliableController {

	// fetch all app cursors.
	@GetMapping("/application-cursors")
	public List<?> fetchCursors() {

		Result<Record> cursors = new ApplicationCursorDao().fetchCursors();

		return cursors;

	}

}
