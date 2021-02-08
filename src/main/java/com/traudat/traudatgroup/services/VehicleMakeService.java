package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.VehicleMake;

public interface VehicleMakeService {
	List<VehicleMake> getVehicleMakes();
	
	VehicleMake save(VehicleMake vehicleMake);
	
	Optional<VehicleMake> findById(int id);
	
	void deleteById(int id);
}
