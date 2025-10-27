package com.app;

public class Sandbox {
	
	
	// method overloading, fancy.
	static void set(char signal) {
		
	}
	
	static void set(int number) {
		
	}
	
	static void set(String key) {
		
	}
	
	static void set(String key, int number) {
		
	}
	
    static void set(int number, String domain) {
		
	}


	
	public static void main(String[] args) {
		

		set('c');
		set(911);
		set("foo");
		set("foo",100); //
		set(100,"100.com");
		
		
	}
	
}
