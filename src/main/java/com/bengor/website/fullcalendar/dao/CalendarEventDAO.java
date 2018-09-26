package com.bengor.website.fullcalendar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bengor.website.fullcalendar.CalendarEvent;

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
	public void mergeCalendarEvent(CalendarEvent event) {
		
		entityManager.merge(event);
		
	}
	
}
