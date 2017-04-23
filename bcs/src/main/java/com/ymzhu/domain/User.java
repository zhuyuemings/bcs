package com.ymzhu.domain;

public class User {
	private String username;
	private String userpwd;

	public User(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return "User [" + username + "," + userpwd + "]";
	}

}
