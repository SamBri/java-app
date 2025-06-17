package com.app.objects;

import java.lang.reflect.Method;

import org.w3c.dom.Text;




public class App {

	
	public static void main(String[] args) {
		
		
		//String textString = "Hello"; // reference
		String textString = new String("newHello"); // new String, heap.
		System.out.println("inside main, Strings :: before  {text},{hashCode} ==> "+String.format("%s,%s", textString, textString.hashCode()));
		inOut(textString);
		System.out.println("inside main, Strings :: after {text},{hashCode} ==> "+String.format("%s,%s", textString, textString.hashCode()));
		
		System.out.println();
		
		StringBuilder textStringBuilder = new StringBuilder(textString);
		System.out.println("inside main, StringBuilder :: before  {text},{hashCode} ==> "+String.format("%s,%s", textStringBuilder, textStringBuilder.hashCode()));
		inOut(textStringBuilder);
		System.out.println("inside main, StringBuilder :: after  {text},{hashCode} ==> "+String.format("%s,%s", textStringBuilder, textStringBuilder.hashCode()));
		
		
	    System.out.println();
		
		User user = new User("John"); // 
		System.out.println("inside main, User :: before  {text},{hashCode} ==> "+String.format("%s,%s", user, user.hashCode()));
		inOut(user);
		System.out.println("inside main, User :: after  {text},{hashCode} ==> "+String.format("%s,%s", user, user.hashCode()));
		
		
		

		
	}
	
	static void inOut(String inOut) {
		System.out.println("inside inOut, Strings :: before {text},{hashCode} ==> "+String.format("%s,%s", inOut, inOut.hashCode()));
		inOut = inOut.toUpperCase(); // Strings are immutable
		System.out.println("inside inOut, Strings :: after {text},{hashCode} ==> "+String.format("%s,%s", inOut, inOut.hashCode()));
	}
	
	
	static void inOut(StringBuilder inOut) {
		System.out.println("inside inOut, StringBuilder :: before {text},{hashCode} ==> "+String.format("%s,%s", inOut, inOut.hashCode()));
		inOut = inOut.replace(0, inOut.length(), inOut.toString().toUpperCase());  // StringBuilder is mutable
		System.out.println("inside inOut, StringBuilder :: after {text},{hashCode} ==> "+String.format("%s,%s", inOut, inOut.hashCode()));

	}
	
	
	public static void inOut(User user)  {
		
		System.out.println("inside inOut, {class} :: before {text},{hashCode} ==> "+String.format("%s,%s,%s",User.class.getSimpleName() ,user, user.hashCode()));
	     user.setName("modified".toUpperCase());    	// mutating the object itself
		System.out.println("inside inOut, {class} :: after {text},{hashCode} ==> "+String.format("%s,%s,%s",User.class.getSimpleName() ,user, user.hashCode()));

		
		
	}
	

	static class GenericType<T> {

		private T instance;

		public T getInstance() {
			return instance;
		}

		public void setInstance(T instance) {
			this.instance = instance;
		}
		
	
	}
	
	
static class User{
		
		private String name;
		private int id;
		
		public User() {
			// TODO Auto-generated constructor stub
		}
		
		public User(String name) {

			this.id = name.length();
			this.name = name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		
		public int hashCode() {
			return this.id;
		}
		
		
		public String toString() {
			return this.id +":"+name;
		}
		
		
		

	}
	
	
}



