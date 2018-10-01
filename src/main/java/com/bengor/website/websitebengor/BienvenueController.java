package com.bengor.website.websitebengor;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bengor.website.websitebengor.fullcalendar.CalendarEvent;
import com.bengor.website.websitebengor.fullcalendar.Priority;
import com.bengor.website.websitebengor.fullcalendar.services.ICalendarEventService;

@Controller
public class BienvenueController {

	@Autowired
	private ICalendarEventService serviceEvent;

    @RequestMapping("/")
    public String afficherBienvenue(final ModelMap pModel, boolean editMode) {

    	pModel.addAttribute("editMode", editMode);
    	
    	//Searching for events on the database
    	List<CalendarEvent> events = serviceEvent.searchCalendarEvent();
    	
    	//Adding them on the model
    	pModel.addAttribute("eventList", events);
    	
    	//Adding priority values of the enum
    	pModel.addAttribute("priority", Priority.values());
    	
        if (pModel.get("formEvent") == null) {
            pModel.addAttribute("formEvent", new CalendarEvent());
        }
    	
        return "bienvenue";
    }
    
    @RequestMapping(value="/saveOrUpdateEvent", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(value="formEvent") CalendarEvent calendarEvent, final BindingResult pBindingResult, final ModelMap pModel) {
    	 
    	if (!pBindingResult.hasErrors()) {
    		//Merging the calendar event
    		calendarEvent = serviceEvent.mergeCalendarEvent(calendarEvent);
    		
    		//Cleaning the formEvent
            pModel.addAttribute("formEvent", new CalendarEvent());
    	 }
    	return afficherBienvenue(pModel,false);
    }
    
    @RequestMapping(value="/deleteEvent", method = RequestMethod.GET)
    public String delete(@RequestParam(value="idEvent")final Long idEvent, final ModelMap pModel) {
    	
    	CalendarEvent eventToDelete = serviceEvent.getFromId(idEvent);
    	if(eventToDelete != null) {
    		serviceEvent.deleteCalendarEvent(eventToDelete);
    	}
    	
    	return afficherBienvenue(pModel,false);
    }
    
    @RequestMapping(value="/editEvent", method = RequestMethod.GET)
    public String edit(@RequestParam(value="idEvent")final Long idEvent, final ModelMap pModel) {
    	
    	CalendarEvent eventToEdit = serviceEvent.getFromId(idEvent);
    	if(eventToEdit != null) {
    		pModel.addAttribute("formEvent", eventToEdit);
    	}
    	
    	return afficherBienvenue(pModel,true);
    }

}