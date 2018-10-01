package com.bengor.website.websitebengor.fullcalendar;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="CALENDAREVENT")
public class CalendarEvent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1108411495289084447L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//Name of the event
	private String name;
	
	//Additionnal info of the event
	private String info;
	
	//Starting date of the event
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date startingTime;

	//Ending date of the event
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date endingTime;
	
	//Location of the event
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idlocation")
	private Location location;
	
	//Priority of the event
	@Enumerated(EnumType.STRING)
	private Priority priority;

	public CalendarEvent(final String name, final String info, final Date startingTime, final Date endingTime,
			final Location location, final Priority priority) {
		super();
		this.name = name;
		this.info = info;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.location = location;
		this.priority = priority;
	}
	
	public CalendarEvent() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}

	public Date getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(Date endingTime) {
		this.endingTime = endingTime;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
}
