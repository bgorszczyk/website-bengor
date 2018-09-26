package com.bengor.website.fullcalendar.dao;

import java.util.List;

import com.bengor.website.fullcalendar.CalendarEvent;

public interface ICalendarEventDAO {

	List<CalendarEvent> searchCalendarEvent();
	void mergeCalendarEvent(final CalendarEvent events);
}
