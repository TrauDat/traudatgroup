package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.VehicleModel;
import com.traudat.traudatgroup.repositories.VehicleModelRepository;
import com.traudat.traudatgroup.services.VehicleModelService;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	Logger LOG = LogManager.getLogger(VehicleModelServiceImpl.class);
	
	@Override
	public List<VehicleModel> getVehicleModels() {
		List<VehicleModel> listVehicleModels = Collections.emptyList();
		try {
			listVehicleModels = vehicleModelRepository.findAll();
			return listVehicleModels;
		} catch (Exception ex) {
			LOG.error("Error getVehicleModels() in VehicleModelServiceImpl", ex);
		}
		return listVehicleModels;
	}

	@Override
	public VehicleModel save(VehicleModel VehicleModel) {
		try {
			return vehicleModelRepository.save(VehicleModel);
		} catch(Exception ex) {
			LOG.error("Error save() in VehicleModelServiceImpl", ex);
			return null;
		}
	}

	@Override
	public Optional<VehicleModel> findById(int id) {
		Optional<VehicleModel> res = Optional.empty();
		try {
			res = vehicleModelRepository.findById(id);
			if (res.isPresent()) {
				return res;
			}
		} catch (Exception ex) {
			LOG.error("Error findById() VehicleModelServiceImpl", ex);
		}
		return res;
	}

	@Override
	public void deleteById(int id) {
		try {
			vehicleModelRepository.deleteById(id);;
		} catch (Exception ex) {
			LOG.error("Error deleteByid in VehicleModelServiceImpl()",ex);
		}
		
	}

}
