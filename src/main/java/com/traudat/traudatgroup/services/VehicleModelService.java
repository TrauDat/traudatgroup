package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.VehicleModel;

public interface VehicleModelService {
	List<VehicleModel> getVehicleModels();
	
	VehicleModel save(VehicleModel VehicleModel);
	
	Optional<VehicleModel> findById(int id);
	
	void deleteById(int id);
}
