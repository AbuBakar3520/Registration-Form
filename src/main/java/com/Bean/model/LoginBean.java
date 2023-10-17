package com.Bean.model;

public class LoginBean {
private String phoneNO;
private  String password;

public LoginBean() {
	super();
	
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
	return "LoginBean [phoneNO=" + phoneNO + ", password=" + password + "]";
}


}
















