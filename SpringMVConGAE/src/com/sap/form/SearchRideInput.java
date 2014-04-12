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


public class SearchRideInput implements java.io.Serializable {       
	
	
	private String startLoc;
	
	private String endLoc;
	    
	  
	private String startDate; 
	
	     
	private String endDate;


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
	
	   
	
	
	   
	// Getter and Setter methods 
	
	
	
}

