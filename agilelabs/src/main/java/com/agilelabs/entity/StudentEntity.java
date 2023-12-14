package com.agilelabs.entity;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name="studentInfo")
public class StudentEntity {
	
@GeneratedValue
@Id
private int id;
@Column(name = "first_name")
private String firstName;

@Column(name = "last_name")
private String lastName;

@Column(name = "date_of_birth")
@Temporal(TemporalType.DATE)
//dob
private Date dateOfBirth;

@Column(name = "email")
private String email;

@Column(name = "password")
private String password;

@Column(name = "qualification")
private String qualification;

@Column(name = "phone_number")
private long phoneNumber;


public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
@Override
public String toString() {
	return "StudentEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
			+ dateOfBirth + ", email=" + email + ", password=" + password + ", qualification=" + qualification
			+ ", phoneNumber=" + phoneNumber + "]";
}


}
