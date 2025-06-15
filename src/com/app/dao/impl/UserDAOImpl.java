package com.app.dao.impl;

import com.app.dao.UserDAO;
import com.app.factory.DAOFactory;

public class UserDAOImpl implements UserDAO  {

	private DAOFactory daoFactory;

	public UserDAOImpl() {

	}

	public UserDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserById(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	
	
}
