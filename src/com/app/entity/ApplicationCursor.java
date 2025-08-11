package com.app.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "application_cursors")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ApplicationCursor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "pos_x")
	private Integer posX;
	@Column(name = "pos_y")
	private Integer posY;

	@Column(name = "nonce")
	private String nonce;

	@Column(name = "cursorId")
	private String cursorId;

	@Column(name = "name")
	private String name;
	
	
	

}
