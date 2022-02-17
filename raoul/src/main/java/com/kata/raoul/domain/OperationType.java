package com.kata.raoul.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OperationType implements Serializable {

	public static final long DEPOSIT = 1;
	public static final long WITHDRAWAL = 2;
	public static final long CHECKING = 3;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OperationType() {
		
	}
	
	public OperationType(long id)
	{
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}  
}
