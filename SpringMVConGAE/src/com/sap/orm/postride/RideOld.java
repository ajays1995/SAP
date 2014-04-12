package com.sap.orm.postride;

import java.util.Set;   
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
import javax.persistence.OneToMany; 
import javax.persistence.OneToOne;
import javax.persistence.Table;  
import com.sap.orm.postride.User;
import com.sap.orm.postride.Location;

@Entity@Table(name="RIDES") 
public class RideOld implements java.io.Serializable {       
	
	
	@Id    
	@GeneratedValue    
	@Column(name="RIDE_ID")     
	private Integer rideId;           
	
	public Integer getRideId() {
		return rideId;
	}


	public void setRideId(Integer rideId) {
		this.rideId = rideId;
	}


	public String getRideName() {
		return rideName;
	}


	public void setRideName(String rideName) {
		this.rideName = rideName;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}



	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public Integer getRateType() {
		return rateType;
	}


	public void setRateType(Integer rateType) {
		this.rateType = rateType;
	}


	public Integer getRate() {
		return rate;
	}


	public void setRate(Integer rate) {
		this.rate = rate;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Integer getShareFlag() {
		return shareFlag;
	}


	public void setShareFlag(Integer shareFlag) {
		this.shareFlag = shareFlag;
	}


	public String getRideStatus() {
		return rideStatus;
	}


	public void setRideStatus(String rideStatus) {
		this.rideStatus = rideStatus;
	}
	

	public Location getLocation() {
		return location;
	}


	public void setLocation(Location loc) {
		this.location = loc;
	}


	@Column(name="RIDE_N")     
	private String rideName; 
	
	@OneToMany(mappedBy="ride")     
	private Set<User> users; 
	
	@Column(name="USER_TYPE")     
	private String userType; 
	
	@Column(name="USER_STATUS")     
	private String userStatus; 
	
	@OneToOne(mappedBy="ride", cascade=CascadeType.ALL)
	private Location  location; 
	
	@Column(name="START_DATE")     
	private String startDate; 
	
	@Column(name="END_DATE")     
	private String endDate; 
	
	@Column(name="RATE_TYPE")     
	private Integer rateType; 
	
	@Column(name="RATE")     
	private Integer rate; 
	
	@Column(name="NOTES")     
	private String notes; 
	
	@Column(name="SHARE_F")     
	private Integer shareFlag; 
	
	
	@Column(name="RIDE_STATUS")     
	private String rideStatus; 
	
      
	// Getter and Setter methods 
	
	
	
}

