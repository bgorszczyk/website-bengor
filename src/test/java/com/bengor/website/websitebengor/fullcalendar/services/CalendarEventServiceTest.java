package com.bengor.website.websitebengor.fullcalendar.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import com.bengor.website.websitebengor.WebsiteBengorApplication;
import com.bengor.website.websitebengor.fullcalendar.CalendarEvent;
import com.bengor.website.websitebengor.fullcalendar.Location;
import com.bengor.website.websitebengor.fullcalendar.Priority;
import com.bengor.website.websitebengor.fullcalendar.services.ICalendarEventService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=WebsiteBengorApplication.class)
public class CalendarEventServiceTest {

    @Autowired
    private ICalendarEventService calendarEventService;
    
    @Before
    public void setUp() {
    	
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void calendarEventServiceMethodsTest(){
    	
    	//First we test that the search method works
    	List<CalendarEvent> listEventBeforAdd = searchCalendarEventTest();
    	
    	//Then we test to add an event
    	List<CalendarEvent> listEvent = addCalendarEventTest(listEventBeforAdd);
    	
    	//Getting the first element of the event list (we are sure that there is at least one thanks to the add test)
    	CalendarEvent event = getEventFromIdTest(listEvent);
    	
		deleteEventTest(listEvent, event);
    }

	private void deleteEventTest(List<CalendarEvent> listEvent, CalendarEvent event) {
		int nbEventBeforDelete = listEvent.size();
		
		calendarEventService.deleteCalendarEvent(event);
		
    	//Delete the event on the list
    	List<CalendarEvent> listEventAfterDelete = calendarEventService.searchCalendarEvent();
    	
    	int nbEvent = listEventAfterDelete.size();
    	int nbEventExpected = nbEventBeforDelete - 1;

    	//Test if the base has the expected number of elements
    	assertEquals(nbEventExpected,nbEvent);
	}

	private CalendarEvent getEventFromIdTest(List<CalendarEvent> listEventAfterAdd) {
		
		CalendarEvent event = listEventAfterAdd.get(0);
    	Long idEvent = event.getId();
    	CalendarEvent eventFromId = calendarEventService.getFromId(idEvent);
    	
    	//Test that the event returned is not null
    	assertNotNull("Event from id is Null.", eventFromId);
    	
    	//Test that we got the correct event
    	Long idEventFromId = eventFromId.getId();
    	assertEquals(idEventFromId,idEvent);
    	
    	return event;
	}

	private List<CalendarEvent> addCalendarEventTest(List<CalendarEvent> listEventBeforAdd) {
		
		int nbEventBeforAdd = listEventBeforAdd.size();
    	
    	Location location1 = new Location("Paris","75000","Rue de la paix",100);
    	CalendarEvent event1 = new CalendarEvent("Crémaillère","de Doudou",new Date(),null, location1, Priority.MEDIUM);

    	//Adding the new event on base
    	calendarEventService.mergeCalendarEvent(event1);
    	
    	//Adding the same event on the list
    	List<CalendarEvent> listEventAfterAdd = calendarEventService.searchCalendarEvent();
    	
    	int nbEvent = listEventAfterAdd.size();
    	int nbEventExpected = nbEventBeforAdd + 1;
    	
    	//Test if the base has the expected number of elements
    	assertEquals(nbEventExpected,nbEvent);
		return listEventAfterAdd;
	}

	private List<CalendarEvent> searchCalendarEventTest() {
		
		//Getting all events on base
    	List<CalendarEvent> listEventBeforAdd = calendarEventService.searchCalendarEvent();
    	
    	//Test that the list is not null
    	assertNotNull("Event list is Null.", listEventBeforAdd);
		return listEventBeforAdd;
	}
	
	
	
}
