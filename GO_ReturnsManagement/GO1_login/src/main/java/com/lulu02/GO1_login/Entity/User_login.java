package com.lulu02.GO1_login.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
@Table(name="user_login")
@Entity
public class User_login {
	@Id
	int id;
	String User_Name;
	@Size(min = 8, max = 30, message = "password must be at least 8 characters long and less than 30 characters")
	String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User_login [id=" + id + ", User_Name=" + User_Name + ", password=" + password + "]";
	}
	public User_login(int id, String user_Name,
			@Size(min = 8, max = 30, message = "password must be at least 8 characters long and less than 30 characters") String password) {
		super();
		this.id = id;
		User_Name = user_Name;
		this.password = password;
	}
	public User_login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
