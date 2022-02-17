package com.kata.raoul.beans.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kata.raoul.domain.Client;

public class ClientResponseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientResponseBean(Client client) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(client.getFirstName());
		strBuilder.append(" ");
		strBuilder.append(client.getLastName());
		this.fullName = strBuilder.toString();
		this.email = client.getEmail();
		this.phoneNumber = client.getPhoneNumber();
	}
	
	@JsonProperty("full_name")
	private String fullName;
	
	private String email;

	@JsonProperty("phone_number")
	private String phoneNumber;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
