package com.bengor.website.websitebengor.fullcalendar.services;

import java.util.List;

import com.bengor.website.websitebengor.fullcalendar.Location;

public interface ILocationService {
	
	List<Location> searchLocation();
	void mergeLocation(final Location location);
}
