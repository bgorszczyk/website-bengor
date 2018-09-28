package com.bengor.website.websitebengor.fullcalendar.dao;

import java.util.List;

import com.bengor.website.websitebengor.fullcalendar.Location;

public interface ILocationDAO {

	List<Location> searchLocation();
	void mergeLocation(final Location location);
	
}
