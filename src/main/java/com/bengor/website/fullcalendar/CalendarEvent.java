package com.bengor.website.fullcalendar;

import java.util.Date;

public class CalendarEvent {
	
	//Name of the event
	private String name;
	
	//Additionnal info of the event
	private String info;
	
	//Starting date of the event
	private Date startingTime;

	//Ending date of the event
	private Date endingTime;
	
	//Location of the event
	private Location location;
	
	//Priority of the event
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
