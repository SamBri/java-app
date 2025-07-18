package com.app.services.impl;

import static com.app.dao.AbstractApplicationCursorDao.HIBERNATE;
import static com.app.dao.AbstractApplicationCursorDao.JDBC;
import static com.app.dao.AbstractApplicationCursorDao.JOOQ;
import static com.app.dao.AbstractApplicationCursorDao.JPA;
import static com.app.dao.AbstractApplicationCursorDao.MOET;
import static com.app.jooq.tables.ApplicationCursors.APPLICATION_CURSORS;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;

import com.app.dao.AbstractApplicationCursorDao;
import com.app.dao.ApplicationCursorDao;
import com.app.dao.impl.JdbcApplicationCursorDaoImpl;
import com.app.dao.impl.JooqApplicationCursorDaoImpl;
import com.app.dao.impl.JpaApplicationCursorDaoImpl;
import com.app.dao.impl.orm.HibernateApplicationCursorDaoImpl;
import com.app.dao.impl.orm.MoetApplicationCursorDaoImpl;
import com.app.dto.AppCursorDto;
import com.app.services.ApplicationCursorService;

public class ApplicationCursorServiceImpl implements ApplicationCursorService {

	private ApplicationCursorDao cursorDao;

	private AbstractApplicationCursorDao abstractDao;;

	ApplicationCursorServiceImpl(ApplicationCursorDao dao) { // among which of the providers.
		this.cursorDao = dao;
	}

	public ApplicationCursorServiceImpl(int id) { // among which of the providers.

		this.abstractDao = switch (id) {

		case JOOQ:
			yield new JooqApplicationCursorDaoImpl();
		// yield new com.app.dao.impl.jooq.ApplicationCursorDaoImpl();
		case JPA:
			yield new JpaApplicationCursorDaoImpl();
		// yield new com.app.dao.impl.jpa.ApplicationCursorDaoImpl();
		case JDBC:
			yield new JdbcApplicationCursorDaoImpl();
		// yield new com.app.dao.impl.jdbc.ApplicationCursorDaoImpl();
		case MOET:
			yield new MoetApplicationCursorDaoImpl();
		// yield new com.app.dao.impl.orm.moet.ApplicationCursorDaoImpl();
		case HIBERNATE:
			yield new HibernateApplicationCursorDaoImpl();
		// yield new com.app.dao.impl.orm.hibernate.ApplicationCursorDaoImpl();
		default:
			yield new JooqApplicationCursorDaoImpl();
		// yield new com.app.dao.impl.jooq.ApplicationCursorDaoImpl(); // JOOQ

		};
	}

	// fetch all app cursors.
	public List<AppCursorDto> fetchCursors() {
		try {

			List<AppCursorDto> list = abstractDao.fetchCursors();
			
			return list;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;

	}

	// create cursor
	public String createCursor(AppCursorDto dto) {

		// abstractDao = new ApplicationCursorDaoImpl(); // making shot calls
		if (abstractDao.createCursor(dto) == 1) {
			return "created";
		}

		return "failed";

	}

	@Override
	public List<AppCursorDto> fetchCursor(String cursorId) {
	
		try {

			List<AppCursorDto> list = abstractDao.fetchCursor(cursorId);
			
			return list;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
	
	
	

}
