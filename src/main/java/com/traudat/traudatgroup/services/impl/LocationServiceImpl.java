package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.common.CustomException;
import com.traudat.traudatgroup.models.Location;
import com.traudat.traudatgroup.repositories.LocationRepository;
import com.traudat.traudatgroup.services.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	Logger LOG = LogManager.getLogger(LocationServiceImpl.class);	
	
	@Override
	public List<Location> getLocations() {
		List<Location> listLocations = Collections.emptyList();
		try {
			listLocations = locationRepository.findAll();
			return listLocations;
		} catch (Exception ex) {
			LOG.error("Error getLocations() in LocationServiceImpl", ex);
		}
		return listLocations;
	}

	@Override
	public Location save(Location location) {
		try {
			return locationRepository.save(location);
		} catch(Exception ex) {
			LOG.error("Error save() in LocationServiceImpl", ex);
			return null;
		}
	}

	@Override
	public Optional<Location> findById(int id) {
		Optional<Location> res = Optional.empty();
		try {
			res = locationRepository.findById(id);
			if (res.isPresent()) {
				return res;
			}
		} catch (Exception ex) {
			LOG.error("Error findById() LocationServiceImpl", ex);
		}
		return res;
	}

	@Override
	public void deleteById(int id) {
		try {
			locationRepository.deleteById(id);;
		} catch (Exception ex) {
			LOG.error("Error deleteByid in LocationServiceImpl()",ex);
		}
	}

}
