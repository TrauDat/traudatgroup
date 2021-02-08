package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.Location;

public interface LocationService {

	List<Location> getLocations();
	
	Location save(Location location);
	
	Optional<Location> findById(int id);
	
	void deleteById(int id);
}
