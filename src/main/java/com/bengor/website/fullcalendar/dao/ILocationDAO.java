package com.bengor.website.fullcalendar.dao;

import java.util.List;

import com.bengor.website.fullcalendar.Location;

public interface ILocationDAO {

	List<Location> searchLocation();
	void mergeLocation(final Location location);
	
}
