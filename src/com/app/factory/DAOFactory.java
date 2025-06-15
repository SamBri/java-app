package com.app.factory;

import com.app.databases.mysql.MySqlDAOFactory;
import com.app.databases.oracle.OracleDAOFactory;

public abstract class DAOFactory {

	public final static int MYSQL = 1;
	public final static int ORACLE = 2;

	public abstract void add();

	public abstract void get();

	public abstract void remove();

	
	// factory pattern.
	public static DAOFactory getDaoFactory(int database) {

		DAOFactory daoFactory = switch (database) {
		case MYSQL -> new MySqlDAOFactory();
		case ORACLE -> new OracleDAOFactory();
		default -> null;
		};

		return daoFactory;
	}

}
