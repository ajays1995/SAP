package com.sap.orm.postride;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity@Table(name="USER") 
public class User {       
	
	@Id    
	@GeneratedValue    
	@Column(name="USER_ID")     
	private Long userId;    
	
	@Column(name="FIRST_N")     
	private String firstname;           
	
	@Column(name="LAST_N")     
	private String lastname;           
	
	@Column(name="EMAIL_ID")     
	private String emailId;           
	
	@Column(name="PHONE_NO")     
	private String phoneNo;   
	
	@Column(name="USER_TYPE")     
	private String userType;  
	
	@Column(name="RIDE_ID")     
	private Integer rideId;  
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ACTIVE")
	private char active ='N';
	    
	//private Ride ride;    
	
	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
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

