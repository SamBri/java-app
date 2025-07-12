package com.app.dto;

import lombok.Data;

@Data
public class AppCursorDto {

	private int id;
	private String name;
	private int posX;
	private int posY;
	private String nonce;
	private String cursorId;

}
