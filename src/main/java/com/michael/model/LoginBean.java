package com.michael.model;

import com.michael.model.RegisterBean;

public class LoginBean{
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validateLogin() {
		/*Check the table to confirm data*/
		RegisterBean rb= new RegisterBean();
		if(username.equals(rb.getUsername()) && password.equals(rb.getPassword()))
			return true;
		return false;
	}
}
