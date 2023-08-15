package com.project.quiz.model;

public class User {
	private int id;
	private String username, password, email;
	private int roleId;
	
	public User() {
		super();
	}
	public User(String username, String password, String email, int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roleId = roleId;
	}
	public User(int id, String username, String password, String email, int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roleId = roleId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
