package com.bengor.website.websitebengor.fullcalendar.services;

import java.util.List;

import com.bengor.website.websitebengor.fullcalendar.CalendarEvent;

public interface ICalendarEventService {

	List<CalendarEvent> searchCalendarEvent();
	void mergeCalendarEvent(final CalendarEvent event);
}
