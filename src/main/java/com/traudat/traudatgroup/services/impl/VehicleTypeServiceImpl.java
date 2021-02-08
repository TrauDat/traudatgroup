package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.VehicleType;
import com.traudat.traudatgroup.repositories.VehicleTypeRepository;
import com.traudat.traudatgroup.services.VehicleTypeService;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	Logger LOG = LogManager.getLogger(VehicleTypeServiceImpl.class);
	
	@Override
	public List<VehicleType> getVehicleTypes() {
		List<VehicleType> listVehicleTypes = Collections.emptyList();
		try {
			listVehicleTypes = vehicleTypeRepository.findAll();
			return listVehicleTypes;
		} catch (Exception ex) {
			LOG.error("Error getVehicleTypes() in VehicleTypeServiceImpl", ex);
		}
		return listVehicleTypes;
	}

	@Override
	public VehicleType save(VehicleType VehicleType) {
		try {
			return vehicleTypeRepository.save(VehicleType);
		} catch(Exception ex) {
			LOG.error("Error save() in VehicleTypeServiceImpl", ex);
			return null;
		}
	}

	@Override
	public Optional<VehicleType> findById(int id) {
		Optional<VehicleType> res = Optional.empty();
		try {
			res = vehicleTypeRepository.findById(id);
			if (res.isPresent()) {
				return res;
			}
		} catch (Exception ex) {
			LOG.error("Error findById() VehicleTypeServiceImpl", ex);
		}
		return res;
	}

	@Override
	public void deleteById(int id) {
		try {
			vehicleTypeRepository.deleteById(id);;
		} catch (Exception ex) {
			LOG.error("Error deleteByid in VehicleTypeServiceImpl()",ex);
		}
		
	}

}
