package com.bengor.website.fullcalendar.services;

import java.util.List;

import com.bengor.website.fullcalendar.Location;

public interface ILocationService {
	
	List<Location> searchLocation();
	void mergeLocation(final Location location);
}
