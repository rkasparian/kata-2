package com.kata.raoul.beans.response;

import java.io.Serializable;

public class JwtResponseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String jwttoken;

	public JwtResponseBean(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}