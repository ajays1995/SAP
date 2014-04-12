package com.sap.orm.postride;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity@Table(name="LOCATION") 
public class Location {       
	
	@Id    
	@GeneratedValue    
	@Column(name="LOC_ID")     
	private Long locId;    	

	@Column(name="FROM_LATD")     
	private String fromLat;           
	
	@Column(name="FROM_LONGTD")     
	private String fromLong;           
	
	@Column(name="FROM_COMP_ADDR")     
	private String fromCompAddr;         
	
	@Column(name="TO_LATD")     
	private String toLat;           
	
	@Column(name="TO_LONGTD")     
	private String toLong;           
	
	@Column(name="TO_COMP_ADDR")     
	private String toCompAddr;   
	    
	
	@ManyToOne    
	@JoinColumn(name="RIDE_ID")     
	private Ride ride;    
	
	public Location() {               }

	public Long getLocId() {
		return locId;
	}

	public void setLocId(Long locId) {
		this.locId = locId;
	}

	public String getFromLat() {
		return fromLat;
	}

	public void setFromLat(String fromLat) {
		this.fromLat = fromLat;
	}

	public String getFromLong() {
		return fromLong;
	}

	public void setFromLong(String fromLong) {
		this.fromLong = fromLong;
	}

	public String getFromCompAddr() {
		return fromCompAddr;
	}

	public void setFromCompAddr(String fromCompAddr) {
		this.fromCompAddr = fromCompAddr;
	}

	public String getToLat() {
		return toLat;
	}

	public void setToLat(String toLat) {
		this.toLat = toLat;
	}

	public String getToLong() {
		return toLong;
	}

	public void setToLong(String toLong) {
		this.toLong = toLong;
	}

	public String getToCompAddr() {
		return toCompAddr;
	}

	public void setToCompAddr(String toCompAddr) {
		this.toCompAddr = toCompAddr;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}           
	
	/*public Location(String lat, String longtd, String compaddr) 
	{         
		this.latitude = lat;         
		this.longitude = longtd;              
		this.compAddr = compaddr;   
		
	}*/

	    


	
}

