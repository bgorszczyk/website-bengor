package com.bengor.website.websitebengor.fullcalendar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bengor.website.websitebengor.fullcalendar.CalendarEvent;

@Repository
public class CalendarEventDAO implements ICalendarEventDAO {
	
	@PersistenceContext(name="myJpaPersistenceUnit")
	private EntityManager entityManager;
	
	public List<CalendarEvent> searchCalendarEvent() {

        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<CalendarEvent> lCriteriaQuery = lCriteriaBuilder.createQuery(CalendarEvent.class);
        final Root<CalendarEvent> lRoot = lCriteriaQuery.from(CalendarEvent.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<CalendarEvent> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
        
        List<CalendarEvent> returnList = lTypedQuery.getResultList();
        return returnList;
	}

	@Transactional
	public CalendarEvent mergeCalendarEvent(CalendarEvent event) {
		
		return entityManager.merge(event);
		
	}

	@Transactional
	public void deleteCalendarEvent(CalendarEvent event) {
		
		entityManager.remove(event);
		
	}
	
	public CalendarEvent getFromId(final Long idEvent) {
		
		CalendarEvent calendarEvent = entityManager.find(CalendarEvent.class, idEvent);
		return calendarEvent;
		
	}
	
}
