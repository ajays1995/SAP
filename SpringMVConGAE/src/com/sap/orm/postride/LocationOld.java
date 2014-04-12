package com.sap.orm.postride;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity@Table(name="LOCATION") 
public class LocationOld {       
	
	@Id    
	@GeneratedValue    
	@Column(name="LOC_ID")     
	private Long locId;    	

	@Column(name="LATD")     
	private String latitude;           
	
	@Column(name="LONGTD")     
	private String longitude;           
	
	@Column(name="COMP_ADDR")     
	private String compAddr;           
	    
	
	@ManyToOne    
	@JoinColumn(name="RIDE_ID")     
	private Ride ride;    
	
	public LocationOld() {               }           
	
	public LocationOld(String lat, String longtd, String compaddr) 
	{         
		this.latitude = lat;         
		this.longitude = longtd;              
		this.compAddr = compaddr;   
		
	}

	public Long getLocId() {
		return locId;
	}

	public void setLocId(Long locId) {
		this.locId = locId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCompAddr() {
		return compAddr;
	}

	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}       


	
}

