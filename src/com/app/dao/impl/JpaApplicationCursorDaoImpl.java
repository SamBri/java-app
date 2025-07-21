package com.app.dao.impl;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.app.dao.AbstractApplicationCursorDao;
import com.app.dto.AppCursorDto;
import com.app.entity.ApplicationCursor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceConfiguration;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import static jakarta.persistence.PersistenceConfiguration.*;

//Application Cursor Dao
public class JpaApplicationCursorDaoImpl extends AbstractApplicationCursorDao {

	private EntityManager em;

	{
		// using jpa - persistence provider is EclipseLink.
		EntityManagerFactory eclipseLinkJpaEmf = new PersistenceConfiguration("JavaAppPU") // class file alternative to persistence.xml
				.managedClass(ApplicationCursor.class)
				.jtaDataSource("jdbc/java_app")
				.property(JDBC_URL, "jdbc:mysql://localhost:3306/java_app")
				.property(JDBC_USER, "root")
				.property(JDBC_PASSWORD, "BlueObjectx1")
				.property(JDBC_DRIVER, "com.mysql.cj.jdbc.Driver")
				.provider("org.eclipse.persistence.jpa.PersistenceProvider") // worked
				.createEntityManagerFactory();
		
		
		//using jpa - persistence provider is hibernate
		// properties read from hibernate.properties file by hibernate
		EntityManagerFactory hibernateJpaEmf = 
				new PersistenceConfiguration("JavaAppPU") //still class file alternative to persistence.xml
				.managedClass(ApplicationCursor.class)
				.createEntityManagerFactory();
		
		
		this.em = eclipseLinkJpaEmf.createEntityManager();
	}

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

	public static void main(String[] args) {

		// using jpa - persistence provider is EclipseLink.
	EntityManagerFactory jpa = new PersistenceConfiguration("JavaAppPU") // class file alternative to persistence.xml
			.managedClass(ApplicationCursor.class)
			.property(JDBC_URL, "jdbc:mysql://localhost:3306/java_app")
			.property(JDBC_USER, "root")
			.property(JDBC_PASSWORD, "BlueObjectx1")
			.property(JDBC_DRIVER, "com.mysql.cj.jdbc.Driver")
			.provider("org.eclipse.persistence.jpa.PersistenceProvider") // worked
			.createEntityManagerFactory();
		
		//using jpa - persistence provider is hibernate
		// properties read from hibernate.properties file by hibernate
		EntityManagerFactory hibernateJpaEmf = 
				new PersistenceConfiguration("JavaAppPU") //still class file alternative to persistence.xml
				.managedClass(ApplicationCursor.class)
				.createEntityManagerFactory();
		
		
		EntityManager emWithJpa = jpa.createEntityManager();

		EntityManager emWithHibernateJpa = hibernateJpaEmf.createEntityManager();

		System.out.println(emWithJpa.find(ApplicationCursor.class, 1));
		//System.out.println(emWithHibernateJpa.find(ApplicationCursor.class, 1));


	}

}
