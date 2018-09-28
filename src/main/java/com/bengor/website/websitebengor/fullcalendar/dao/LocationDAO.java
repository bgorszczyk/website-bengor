package com.bengor.website.websitebengor.fullcalendar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bengor.website.websitebengor.fullcalendar.Location;

@Repository
public class LocationDAO implements ILocationDAO{

	@PersistenceContext(name="myJpaPersistenceUnit")
	private EntityManager entityManager;
	
	public List<Location> searchLocation() {

        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Location> lCriteriaQuery = lCriteriaBuilder.createQuery(Location.class);
        final Root<Location> lRoot = lCriteriaQuery.from(Location.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Location> lTypedQuery = entityManager.createQuery(lCriteriaQuery);
        
        List<Location> returnList = lTypedQuery.getResultList();
        return returnList;
	}

	@Transactional
	public void mergeLocation(Location location) {
		
		entityManager.merge(location);
		
	}
	

}
