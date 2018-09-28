package com.bengor.website.websitebengor.fullcalendar;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -388504515054191690L;

	@Id
	@Column(name = "idlocation")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	protected String cityName;

	protected String postalCode;
	
	protected String street;
	
	protected Integer streetNumber;
	
	public Location() {
		super();
	};
	
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

	/**This method returns a readable string of every information stored on the Location object
	 * 
	 * @return String
	 * */
	public String toString() {
		return (streetNumber != null ? streetNumber : "" ) + " " + street + " " + postalCode + " " + cityName;
	}
}
