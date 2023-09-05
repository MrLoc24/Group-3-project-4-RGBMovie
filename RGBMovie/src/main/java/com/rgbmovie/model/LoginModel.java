package com.rgbmovie.model;

import lombok.Data;

@Data
public class LoginModel {
	private String username;
	private String password;
	public LoginModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	 public LoginModel() {
		// TODO Auto-generated constructor stub
	}
	
	
}
