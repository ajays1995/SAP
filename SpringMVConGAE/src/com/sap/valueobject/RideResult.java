package com.sap.valueobject;



public class RideResult {
	
	String rideStartDate;
	String rideEndDate;

	String rate;
	String seatsLeft;

	String rideFromAddr;
	String rideToAddr;
	String rideName;
	public String getRideStartDate() {
		return rideStartDate;
	}
	public void setRideStartDate(String rideStartDate) {
		this.rideStartDate = rideStartDate;
	}
	public String getRideEndDate() {
		return rideEndDate;
	}
	public void setRideEndDate(String rideEndDate) {
		this.rideEndDate = rideEndDate;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getSeatsLeft() {
		return seatsLeft;
	}
	public void setSeatsLeft(String seatsLeft) {
		this.seatsLeft = seatsLeft;
	}
	public String getRideFromAddr() {
		return rideFromAddr;
	}
	public void setRideFromAddr(String rideFromAddr) {
		this.rideFromAddr = rideFromAddr;
	}
	public String getRideToAddr() {
		return rideToAddr;
	}
	public void setRideToAddr(String rideToAddr) {
		this.rideToAddr = rideToAddr;
	}
	public String getRideName() {
		return rideName;
	}
	public void setRideName(String rideName) {
		this.rideName = rideName;
	}

	
}
