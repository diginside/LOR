package com.lor.rentalapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@Entity
@Table(name="APPLICANT")
public class Applicant {
	
	public Applicant() {
		
	}
	
	public Applicant (String email, String phone) {
		this.email = email;
		this.mobilePhone = phone;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="APPLICANT_ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="MID_NAME")
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="SS_NUM")
	public String getSsNum() {
		return ssNum;
	}
	public void setSsNum(String ssNum) {
		this.ssNum = ssNum;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name="DL_NUM")
	public String getDlNum() {
		return dlNum;
	}
	public void setDlNum(String dlNum) {
		this.dlNum = dlNum;
	}

	@Column(name="DL_STATE")
	public String getDlState() {
		return dlState;
	}
	public void setDlState(String dlState) {
		this.dlState = dlState;
	}
	
	@Column(name="HOME_PHONE")
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name="MOBILE_PHONE")
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	private String id;
	private String firstName;
	private String midName;
	private String lastName;
	private String ssNum;
	private Date birthDate;
	private String dlNum; //Driver's License Number
	private String dlState; //Driver's license issuing state
	private String email;
	private String homePhone;
	private String mobilePhone;

}
