package controller;

import model.Song;
import model.account;

public class accountBuilder {
	

	private String username,password;

	public accountBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	public accountBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public account getAccount()
	{
		return new account(username, password);
	}
	
	
}
