package com.app.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/reliable")
@CrossOrigin(origins = "*") // enable cross origin on the controller level for all origins
//@Slf4j
public class ReliableController {
	

	int x; // instance variable - default value, 0

	
	
    // dao instance.
	// fetch a cursor
	public Object getAppCursor(String cursorId) {
		return null;	
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args) {
		
		int x;
		x = 1; // robust.
		
		System.out.println(x); // 1.
		
		
		
		// x= new ReliableController().x; // lambda.
		ReliableController rc = new ReliableController();
		x = rc.x;
		
		System.out.println(x); // 0.
		
		// payment app.
		// frs. nfs. 
		
		// reliability.
		
		// performance.
		
		// security.
		
		// scalability.
		
	}
	
	
	
	
}


class Cursor{
	int x;
	int y;
	String nonce;
}



