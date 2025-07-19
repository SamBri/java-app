package com.app.dao.impl;

import java.util.List;

import com.app.dao.AbstractApplicationCursorDao;
import com.app.dto.AppCursorDto;
import com.app.entity.ApplicationCursor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

//Application Cursor Dao
public class JpaApplicationCursorDaoImpl extends AbstractApplicationCursorDao {

	private String userName = "root";
	private String password = "BlueObjectx1"; // change as you want
	private String url = "jdbc:mysql://localhost:3306/java_app";

	@PersistenceContext
	private EntityManager em;

	public List fetchCursor(String cursorId) {

		ApplicationCursor appCursor = em.find(ApplicationCursor.class, cursorId);

		return List.of(appCursor);

	}

	public List fetchCursors() {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<ApplicationCursor> cq = cb.createQuery(ApplicationCursor.class);

		Root<ApplicationCursor> appCursor = cq.from(ApplicationCursor.class);

		cq.select(appCursor);

		TypedQuery<ApplicationCursor> tq = em.createQuery(cq);

		return tq.getResultList();
	}

	public int createCursor(AppCursorDto dto) {

		return -1;
	}

}
