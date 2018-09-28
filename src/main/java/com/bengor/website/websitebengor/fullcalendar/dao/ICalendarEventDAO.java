package com.bengor.website.websitebengor.fullcalendar.dao;

import java.util.List;

import com.bengor.website.websitebengor.fullcalendar.CalendarEvent;

public interface ICalendarEventDAO {

	List<CalendarEvent> searchCalendarEvent();
	void mergeCalendarEvent(final CalendarEvent events);
}
