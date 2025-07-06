package com.app;

import static com.app.Utils.sum;

import java.util.function.Supplier;

import com.app.Utils;
import com.app.bridges.adapters.abstracts.impl.AppleKeyboardAbstractWriterAdapterImpl;
import com.app.bridges.adapters.impl.GoogleKeyboardAdapter;
import com.app.bridges.adapters.impl.TypeWriterKeyboardAdapter;
import com.app.bridges.adapters.lambdas.LambdaWriterAdapter;
import com.app.bridges.objects.Keyboard;
import com.app.bridges.objects.TypeWriter;
import com.app.bridges.writers.TextWriter;
import com.app.dao.UserDAO;
import com.app.dao.impl.UserDAOImpl;
import com.app.factory.DAOFactory;

import io.sdk.apple.AppleKeyboard;
import io.sdk.google.GoogleKeyboard;




public class App {

	public static void main(String[] args) {

		// static import
		sum(1, 2);

		// functational interfaces,SAM
		Utils myWhoami = () -> System.out.println();
		myWhoami.whoami();

		// method reference
		Utils mrWhoami = System.out::println;
		mrWhoami.whoami();

		// dao pattern + factory pattern + dependency inversion
		UserDAO mySqlUserDao = new UserDAOImpl(DAOFactory.getDaoFactory(DAOFactory.MYSQL));
		mySqlUserDao.createUser();
		mySqlUserDao.getUserById(1);
		mySqlUserDao.getUsers();
		mySqlUserDao.deleteUser(1);

		// dao pattern + factory pattern + dependency inversion
		UserDAO oracleUserDao = new UserDAOImpl(DAOFactory.getDaoFactory(DAOFactory.ORACLE));
		oracleUserDao.createUser();
		oracleUserDao.getUserById(1);
		oracleUserDao.getUsers();
		oracleUserDao.deleteUser(1);

		// a standard keyboard.
		Keyboard keyboard = new Keyboard();

		// create a keyboard from a or as a typewriter
		TypeWriter typeWriter = new TypeWriter(); // a type writer is an object of its own specifications
		Keyboard typeWriterKeyboard = new Keyboard(new TypeWriterKeyboardAdapter(typeWriter)); // bridge pattern

		GoogleKeyboard googleKeyboard = new GoogleKeyboard();
		Keyboard myGoogleKeyboard = new Keyboard(new GoogleKeyboardAdapter(googleKeyboard)); // bridge pattern - marker
																								// interface(

		AppleKeyboard appleKeyboard = new AppleKeyboard();
		Keyboard myOwnAppleKeyboard = new Keyboard(new AppleKeyboardAbstractWriterAdapterImpl(appleKeyboard)); // bridge
																												// pattern
																												// -
																												// abstract
																												// class

		LambdaWriterAdapter lambdWriter = () -> new GoogleKeyboardAdapter(googleKeyboard);
		Keyboard lambdaKeyboard = new Keyboard(lambdWriter); // bridge pattern - lambda

	}


}
