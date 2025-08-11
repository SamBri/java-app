package com.app.dao.impl.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.app.dao.AbstractApplicationCursorDao;
import com.app.dto.AppCursorDto;
import com.app.entity.ApplicationCursor;

//Application Cursor Dao
public class HibernateApplicationCursorDaoImpl extends AbstractApplicationCursorDao {

	private SessionFactory sessionFactory;

// make a db connection.
	public SessionFactory  getSession() {

  	  // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .build();     
        try {
        	SessionFactory  sessionFactory =
                    new MetadataSources(registry)             
                            .addAnnotatedClass(ApplicationCursor.class)   
                            .buildMetadata()                  
                            .buildSessionFactory();    
        	
    		return sessionFactory;

        }
        catch (Exception e) {
        	e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
        
        return null;
	}

	public List fetchCursor(String cursorId) {

		return null;

	}

	public List fetchCursors() {

		return null;
	}

	public int createCursor(AppCursorDto dto) {

		return -1;
	}
	
	
	

}
