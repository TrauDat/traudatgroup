package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.VehicleStatus;

public interface VehicleStatusService {
	List<VehicleStatus> getVehicleStatuses();
	
	VehicleStatus save(VehicleStatus VehicleStatus);
	
	Optional<VehicleStatus> findById(int id);
	
	void deleteById(int id);
}
