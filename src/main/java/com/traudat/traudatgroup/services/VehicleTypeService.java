package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.VehicleType;

public interface VehicleTypeService {
	List<VehicleType> getVehicleTypes();
	
	VehicleType save(VehicleType VehicleType);
	
	Optional<VehicleType> findById(int id);
	
	void deleteById(int id);
}
