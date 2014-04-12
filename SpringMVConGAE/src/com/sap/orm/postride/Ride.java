package com.sap.orm.postride;

import java.util.Set;   
import java.util.List;
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
import javax.persistence.OneToMany; 
import javax.persistence.Table;  
import com.sap.orm.postride.User;
import com.sap.orm.postride.Location;

@Entity@Table(name="RIDES") 
public class Ride implements java.io.Serializable {       
	
	
	@Id    
	@GeneratedValue    
	@Column(name="RIDE_ID")     
	private Integer rideId;           
	
	@Column(name="RIDE_N")     
	private String rideName; 
	
	@Column(name="MAX_ALLOWED")     
	private Integer maxAllowed; 
	
	@Column(name="SEATS_LEFT")     
	private Integer seatsLeft; 
	
	@OneToMany(mappedBy="ride")    
	private List<Location>  locations; 
	
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


	public Integer getMaxAllowed() {
		return maxAllowed;
	}


	public void setMaxAllowed(Integer maxAllowed) {
		this.maxAllowed = maxAllowed;
	}


	public Integer getSeatsLeft() {
		return seatsLeft;
	}


	public void setSeatsLeft(Integer seatsLeft) {
		this.seatsLeft = seatsLeft;
	}


	public List<Location> getLocations() {
		return locations;
	}


	public void setLocations(List<Location> locations) {
		this.locations = locations;
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
	
      
	// Getter and Setter methods 
	
	
	
}

