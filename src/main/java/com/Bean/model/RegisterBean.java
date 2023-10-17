package com.Bean.model;

public class RegisterBean{
private String userName;
private String email;
private String phoneNO;
private String password;
/**
 * 
 */
public RegisterBean() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNO() {
	return phoneNO;
}
public void setPhoneNO(String phoneNO) {
	this.phoneNO = phoneNO;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "RegisterBean [userName=" + userName + ", email=" + email + ", phoneNO=" + phoneNO + ", password=" + password
			+ "]";
}



}