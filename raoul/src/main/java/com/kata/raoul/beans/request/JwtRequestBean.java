package com.kata.raoul.beans.request;

import java.io.Serializable;

import com.sun.istack.NotNull;

public class JwtRequestBean implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	@NotNull
	private String username;
	@NotNull
	private String password;
	
	//need default constructor for JSON Parsing
	public JwtRequestBean()
	{
		
	}

	public JwtRequestBean(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
