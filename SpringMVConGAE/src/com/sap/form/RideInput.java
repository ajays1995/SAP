package com.sap.form;

import java.util.Set;   
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
import javax.persistence.OneToMany; 
import javax.persistence.Table;  
import com.sap.orm.postride.User;
import com.sap.orm.postride.Location;


public class RideInput implements java.io.Serializable {       
	
	
	private String startLoc;
	
	private String endLoc;
	    
	  
	private String startDate; 
	
	     
	private String endDate; 
	
	   
	private Integer rateType; 
	
	    
	private Integer rate; 
	   
	private String notes; 
	   
	private Integer shareFlag;
	
	private Integer maxAllowed;

	public String getStartLoc() {
		return startLoc;
	}

	public void setStartLoc(String startLoc) {
		this.startLoc = startLoc;
	}

	public String getEndLoc() {
		return endLoc;
	}

	public void setEndLoc(String endLoc) {
		this.endLoc = endLoc;
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

	public Integer getMaxAllowed() {
		return maxAllowed;
	}

	public void setMaxAllowed(Integer maxAllowed) {
		this.maxAllowed = maxAllowed;
	}

	
	// Getter and Setter methods 
	
	
	
}

