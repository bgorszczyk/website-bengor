package com.bengor.website.websitebengor.fullcalendar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bengor.website.websitebengor.fullcalendar.CalendarEvent;
import com.bengor.website.websitebengor.fullcalendar.dao.ICalendarEventDAO;

@Service
public class CalendarEventService implements ICalendarEventService{
	
    @Autowired
    private ICalendarEventDAO dao;

    @Transactional(readOnly=true)
    public List<CalendarEvent> searchCalendarEvent() {
        return dao.searchCalendarEvent();
    }

	@Override
	public void mergeCalendarEvent(CalendarEvent event) {
		
		dao.mergeCalendarEvent(event);		
	}
}
