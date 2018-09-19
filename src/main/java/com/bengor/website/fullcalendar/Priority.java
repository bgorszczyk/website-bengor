package com.bengor.website.fullcalendar;

public enum Priority {

	HIGH ("High Priority"),
	MEDIUM("Medium Priority"),
	LOW("Low Priority");
	
	private final String label;

	private Priority(String label) {
		this.label = label;
	}
	
}
