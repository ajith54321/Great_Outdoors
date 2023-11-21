package com.lulu02.GO1_login.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Table(name="Admin_login")
@Entity
public class Admin {
@Id
int id ;
@NotBlank(message = " UserName is mandatory")
@Size(min=2, max=30, message="User_Name must be at least 2 characters long and less than 30 characters ")
String user_name;
@NotBlank(message = " Password is mandatory")
@Size(min = 8, max = 30, message = "password must be at least 8 characters long and less than 30 characters")
String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Admin [id=" + id + ", user_name=" + user_name + ", password=" + password + "]";
}
public Admin(int id, String user_name, String password) {
	super();
	this.id = id;
	this.user_name = user_name;
	this.password = password;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}

}
