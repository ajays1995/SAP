package com.sap.orm.postride;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Table(name="USER") 
public class User {       
	
	@Id    
	@GeneratedValue    
	@Column(name="USER_ID")     
	private Long userId;    
	
	@Column(name="FIRST_N",length=25)     
	private String firstname;           
	
	@Column(name="LAST_N",length=25)     
	private String lastname;           
	
	@Column(name="EMAIL_ID",length=100)  
	private String emailId;           
	
	@Column(name="PHONE_NO",length=10)     
	private String phoneNo;   
	
	@Column(name="USER_TYPE")     
	private String userType;  
	
	@Column(name="RIDE_ID")     
	private Integer rideId;  
	
	@Column(name="PASSWORD",length=32)
	private String password;
	
	@Column(name="ACCOUNT_VERIFIED")
	private char accountVerified ='N';
	
	@Column(name="GENDER")
	private char gender;
	
	private String userName;
	    
	//private Ride ride;    
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getAccountVerified() {
		return accountVerified;
	}

	public void setAccountVerified(char accountVerified) {
		this.accountVerified = accountVerified;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {               }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getRideId() {
		return rideId;
	}

	public void setRideId(Integer rideId) {
		this.rideId = rideId;
	}

	
	/*public User(String firstname, String lastname, String emailId, String phone) 
	{         
		this.firstname = firstname;         
		this.lastname = lastname;              
		this.emailId = emailId;   
		this.phoneNo = phone;     }   */    


	
}

