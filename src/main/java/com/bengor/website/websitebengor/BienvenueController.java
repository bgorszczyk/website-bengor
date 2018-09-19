package com.bengor.website.websitebengor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bengor.website.fullcalendar.CalendarEvent;
import com.bengor.website.fullcalendar.Location;
import com.bengor.website.fullcalendar.Priority;

@Controller
public class BienvenueController {

    @RequestMapping("/")
    public String afficherBienvenue(final ModelMap pModel) {
    	
     	final Date randomDate = new Date();
    	final Location location1 = new Location("Lyon","69001","Rue de la république",new Integer(38));
    	final CalendarEvent event1 = new CalendarEvent("Very Important Buisness Meeting", "Meeting with my boss concerning X-Files",
    			randomDate, randomDate, location1, Priority.HIGH);
    	final Location location2 = new Location("Lyon","69003","Centre Commercial La Part-Dieu",null);
    	final CalendarEvent event2 = new CalendarEvent("Buying a gift for Mum", "Flowers or paint",
    			randomDate, randomDate, location2, Priority.MEDIUM);
    	final Location location3 = new Location("Lyon","69005","St Patrick Pub",null);
    	final CalendarEvent event3 = new CalendarEvent("Have a beer with Ted", "Ask about his new job",
    			randomDate, randomDate, location3, Priority.LOW);
        
    	final List<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
    	eventList.add(event1);
    	eventList.add(event2);
    	eventList.add(event3);
    	
    	pModel.addAttribute("eventList", eventList);
        return "bienvenue";
    }

}