package com.bengor.website.websitebengor.fullcalendar.dao;

import java.util.List;

import com.bengor.website.websitebengor.fullcalendar.CalendarEvent;

public interface ICalendarEventDAO {

	List<CalendarEvent> searchCalendarEvent();
	CalendarEvent mergeCalendarEvent(final CalendarEvent event);
	void deleteCalendarEvent(final CalendarEvent event);
	CalendarEvent getFromId(final Long idEvent);
}
