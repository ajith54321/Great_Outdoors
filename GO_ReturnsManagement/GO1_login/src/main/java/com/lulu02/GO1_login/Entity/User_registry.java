package com.lulu02.GO1_login.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="user_register")

public class User_registry {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int id;
String email_id;
String first_name;
String last_name;
int phoneno;
String address;
@Size(min = 8, max = 30, message = "password must be at least 8 characters long and less than 30 characters")
String password;
@Size(min = 8, max = 30, message = "confirm_password must be at least 8 characters long and less than 30 characters")
String confirm_password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public int getPhoneno() {
	return phoneno;
}
public void setPhoneno(int phoneno) {
	this.phoneno = phoneno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirm_password() {
	return confirm_password;
}
public void setConfirm_password(String confirm_password) {
	this.confirm_password = confirm_password;
}
@Override
public String toString() {
	return "User_registry [id=" + id + ", email_id=" + email_id + ", first_name=" + first_name + ", last_name="
			+ last_name + ", phoneno=" + phoneno + ", address=" + address + ", password=" + password
			+ ", confirm_password=" + confirm_password + "]";
}
public User_registry() {
	super();
	// TODO Auto-generated constructor stub
}
public User_registry(int id, String email_id, String first_name, String last_name, int phoneno, String address,
		@Size(min = 8, max = 30, message = "password must be at least 8 characters long and less than 30 characters") String password,
		@Size(min = 8, max = 30, message = "confirm_password must be at least 8 characters long and less than 30 characters") String confirm_password) {
	super();
	this.id = id;
	this.email_id = email_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.phoneno = phoneno;
	this.address = address;
	this.password = password;
	this.confirm_password = confirm_password;
}





}