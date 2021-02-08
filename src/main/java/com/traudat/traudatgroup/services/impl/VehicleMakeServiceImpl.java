package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.VehicleMake;
import com.traudat.traudatgroup.repositories.VehicleMakeRepository;
import com.traudat.traudatgroup.services.VehicleMakeService;

@Service
public class VehicleMakeServiceImpl implements VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	Logger LOG = LogManager.getLogger(VehicleMakeServiceImpl.class);
	
	@Override
	public List<VehicleMake> getVehicleMakes() {
		List<VehicleMake> listVehicleMakes = Collections.emptyList();
		try {
			listVehicleMakes = vehicleMakeRepository.findAll();
			return listVehicleMakes;
		} catch (Exception ex) {
			LOG.error("Error getVehicleMakes() in VehicleMakeServiceImpl", ex);
		}
		return listVehicleMakes;
	}

	@Override
	public VehicleMake save(VehicleMake vehicleMake) {
		try {
			return vehicleMakeRepository.save(vehicleMake);
		} catch(Exception ex) {
			LOG.error("Error save() in VehicleMakeServiceImpl", ex);
			return null;
		}
	}

	@Override
	public Optional<VehicleMake> findById(int id) {
		Optional<VehicleMake> res = Optional.empty();
		try {
			res = vehicleMakeRepository.findById(id);
			if (res.isPresent()) {
				return res;
			}
		} catch (Exception ex) {
			LOG.error("Error findById() VehicleMakeServiceImpl", ex);
		}
		return res;
	}

	@Override
	public void deleteById(int id) {
		try {
			vehicleMakeRepository.deleteById(id);;
		} catch (Exception ex) {
			LOG.error("Error deleteByid in VehicleMakeServiceImpl()",ex);
		}
		
	}

}
