package com.bengor.website.websitebengor.fullcalendar.services;

import java.util.List;

import com.bengor.website.websitebengor.fullcalendar.CalendarEvent;

public interface ICalendarEventService {

	List<CalendarEvent> searchCalendarEvent();
	CalendarEvent mergeCalendarEvent(final CalendarEvent event);
	void deleteCalendarEvent(final CalendarEvent event);
	CalendarEvent getFromId(final Long idEvent);
}
