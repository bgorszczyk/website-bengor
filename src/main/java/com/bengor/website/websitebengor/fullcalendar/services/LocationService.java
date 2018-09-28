package com.bengor.website.websitebengor.fullcalendar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bengor.website.websitebengor.fullcalendar.Location;
import com.bengor.website.websitebengor.fullcalendar.dao.ILocationDAO;

@Service
public class LocationService implements ILocationService{
	
    @Autowired
    private ILocationDAO dao;

    @Transactional(readOnly=true)
    public List<Location> searchLocation() {
        return dao.searchLocation();
    }

	@Override
	public void mergeLocation(Location location) {
		
		dao.mergeLocation(location);		
	}
}
