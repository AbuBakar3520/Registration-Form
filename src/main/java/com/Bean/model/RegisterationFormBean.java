package com.Bean.model;
import java.util.Arrays;
public class RegisterationFormBean {
	
private int id;
private byte[] pic;
private String date;
private String applicantName;
private String address;
private String gender;
private String maritalStatus;
private String dob;
private String pan;
private String aadhar;
private String email;
private String phone;
private String qualification;
private String SSC;
private String SSC_Percentage;
private String SSC_Year;
private String HSC;
private String HSC_Percentage;
private String HSC_Year;
private String Graduate;
private String Graduate_Percentage;
private String Graduate_Year;
private String Post_Graduate;
private String Post_Graduate_Percentage;
private String Post_Graduate_Year;
private String sign;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public byte[] getPic() {
	return pic;
}
public void setPic(byte[] pic) {
	this.pic = pic;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getApplicantName() {
	return applicantName;
}
public void setApplicantName(String applicantName) {
	this.applicantName = applicantName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMaritalStatus() {
	return maritalStatus;
}
public void setMaritalStatus(String maritalStatus) {
	this.maritalStatus = maritalStatus;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getPan() {
	return pan;
}
public void setPan(String pan) {
	this.pan = pan;
}
public String getAadhar() {
	return aadhar;
}
public void setAadhar(String aadhar) {
	this.aadhar = aadhar;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getSSC() {
	return SSC;
}
public void setSSC(String sSC) {
	SSC = sSC;
}
public String getSSC_Percentage() {
	return SSC_Percentage;
}
public void setSSC_Percentage(String sSC_Percentage) {
	SSC_Percentage = sSC_Percentage;
}
public String getSSC_Year() {
	return SSC_Year;
}
public void setSSC_Year(String sSC_Year) {
	SSC_Year = sSC_Year;
}
public String getHSC() {
	return HSC;
}
public void setHSC(String hSC) {
	HSC = hSC;
}
public String getHSC_Percentage() {
	return HSC_Percentage;
}
public void setHSC_Percentage(String hSC_Percentage) {
	HSC_Percentage = hSC_Percentage;
}
public String getHSC_Year() {
	return HSC_Year;
}
public void setHSC_Year(String hSC_Year) {
	HSC_Year = hSC_Year;
}
public String getGraduate() {
	return Graduate;
}
public void setGraduate(String graduate) {
	Graduate = graduate;
}
public String getGraduate_Percentage() {
	return Graduate_Percentage;
}
public void setGraduate_Percentage(String graduate_Percentage) {
	Graduate_Percentage = graduate_Percentage;
}
public String getGraduate_Year() {
	return Graduate_Year;
}
public void setGraduate_Year(String graduate_Year) {
	Graduate_Year = graduate_Year;
}
public String getPost_Graduate() {
	return Post_Graduate;
}
public void setPost_Graduate(String post_Graduate) {
	Post_Graduate = post_Graduate;
}
public String getPost_Graduate_Percentage() {
	return Post_Graduate_Percentage;
}
public void setPost_Graduate_Percentage(String post_Graduate_Percentage) {
	Post_Graduate_Percentage = post_Graduate_Percentage;
}
public String getPost_Graduate_Year() {
	return Post_Graduate_Year;
}
public void setPost_Graduate_Year(String post_Graduate_Year) {
	Post_Graduate_Year = post_Graduate_Year;
}
public String getSign() {
	return sign;
}
public void setSign(String sign) {
	this.sign = sign;
}
/**
 * 
 */
public RegisterationFormBean() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "RegisterationFormBean [id=" + id + ", pic=" + Arrays.toString(pic) + ", date=" + date + ", applicantName="
			+ applicantName + ", address=" + address + ", gender=" + gender + ", maritalStatus=" + maritalStatus
			+ ", dob=" + dob + ", pan=" + pan + ", aadhar=" + aadhar + ", email=" + email + ", phone=" + phone
			+ ", qualification=" + qualification + ", SSC=" + SSC + ", SSC_Percentage=" + SSC_Percentage + ", SSC_Year="
			+ SSC_Year + ", HSC=" + HSC + ", HSC_Percentage=" + HSC_Percentage + ", HSC_Year=" + HSC_Year
			+ ", Graduate=" + Graduate + ", Graduate_Percentage=" + Graduate_Percentage + ", Graduate_Year="
			+ Graduate_Year + ", Post_Graduate=" + Post_Graduate + ", Post_Graduate_Percentage="
			+ Post_Graduate_Percentage + ", Post_Graduate_Year=" + Post_Graduate_Year + ", sign=" + sign + "]";
}





}