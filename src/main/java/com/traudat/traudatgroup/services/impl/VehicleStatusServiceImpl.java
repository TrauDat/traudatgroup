package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.VehicleStatus;
import com.traudat.traudatgroup.repositories.VehicleStatusRepository;
import com.traudat.traudatgroup.services.VehicleStatusService;

@Service
public class VehicleStatusServiceImpl implements VehicleStatusService {

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	Logger LOG = LogManager.getLogger(VehicleStatusServiceImpl.class);
	
	@Override
	public List<VehicleStatus> getVehicleStatuses() {
		List<VehicleStatus> listVehicleStatuss = Collections.emptyList();
		try {
			listVehicleStatuss = vehicleStatusRepository.findAll();
			return listVehicleStatuss;
		} catch (Exception ex) {
			LOG.error("Error getVehicleStatuss() in VehicleStatusServiceImpl", ex);
		}
		return listVehicleStatuss;
	}

	@Override
	public VehicleStatus save(VehicleStatus VehicleStatus) {
		try {
			return vehicleStatusRepository.save(VehicleStatus);
		} catch(Exception ex) {
			LOG.error("Error save() in VehicleStatusServiceImpl", ex);
			return null;
		}
	}

	@Override
	public Optional<VehicleStatus> findById(int id) {
		Optional<VehicleStatus> res = Optional.empty();
		try {
			res = vehicleStatusRepository.findById(id);
			if (res.isPresent()) {
				return res;
			}
		} catch (Exception ex) {
			LOG.error("Error findById() VehicleStatusServiceImpl", ex);
		}
		return res;
	}

	@Override
	public void deleteById(int id) {
		try {
			vehicleStatusRepository.deleteById(id);;
		} catch (Exception ex) {
			LOG.error("Error deleteByid in VehicleStatusServiceImpl()",ex);
		}
		
	}

}
