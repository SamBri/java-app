package com.app.dao;


public interface UserDAO {

	void createUser();

	void getUsers();

	void getUserById(int i);

	void updateUser(int userId);

	void deleteUser(int userId);

}
