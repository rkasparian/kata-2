package com.kata.raoul.beans.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.sun.istack.NotNull;

public class ClientUpdateRequestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientUpdateRequestBean() {
		// TODO Auto-generated constructor stub
	}

	@NotNull
	private Long id;
	
	@NotNull
	@JsonProperty("first_name")
	private String firstName;

	@NotNull
	@JsonProperty("last_name")
	private String lastName;

	@NotNull
	private String email;

	@NotNull
	@JsonProperty("phone_number")
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
