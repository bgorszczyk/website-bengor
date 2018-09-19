package com.bengor.website.fullcalendar;

public class Location {
	
	protected String cityName;

	protected String postalCode;
	
	protected String street;
	
	protected Integer streetNumber;
	
	public Location(String cityName, String postalCode, String street, Integer streetNumber) {
		super();
		this.cityName = cityName;
		this.postalCode = postalCode;
		this.street = street;
		this.streetNumber = streetNumber;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	
	public String toString() {
		return (streetNumber != null ? streetNumber : "" ) + " " + street + " " + postalCode + " " + cityName;
	}
}
