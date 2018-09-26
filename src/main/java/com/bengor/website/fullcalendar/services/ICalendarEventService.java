package com.bengor.website.fullcalendar.services;

import java.util.List;

import com.bengor.website.fullcalendar.CalendarEvent;

public interface ICalendarEventService {

	List<CalendarEvent> searchCalendarEvent();
	void mergeCalendarEvent(final CalendarEvent event);
}
