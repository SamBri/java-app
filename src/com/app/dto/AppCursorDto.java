package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppCursorDto {

	private int id;
	private String name;
	private int posX;
	private int posY;
	private String nonce;
	private String cursorId;
	
	

}
