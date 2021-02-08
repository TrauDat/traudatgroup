package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.EmployeeType;
import com.traudat.traudatgroup.repositories.EmployeeTypeRepository;
import com.traudat.traudatgroup.services.EmployeeTypeService;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository EmployeeTypeRepository;
	Logger LOG = LogManager.getLogger(EmployeeTypeServiceImpl.class);
	
	@Override
	public List<EmployeeType> getEmployeeTypes() {
		List<EmployeeType> listEmployeeTypes = Collections.emptyList();
		try {
			listEmployeeTypes = EmployeeTypeRepository.findAll();
			return listEmployeeTypes;
		} catch (Exception ex) {
			LOG.error("Error getEmployeeTypes() in EmployeeTypeServiceImpl", ex);
		}
		return listEmployeeTypes;
	}

	@Override
	public EmployeeType save(EmployeeType EmployeeType) {
		try {
			return EmployeeTypeRepository.save(EmployeeType);
		} catch(Exception ex) {
			LOG.error("Error save() in EmployeeTypeServiceImpl", ex);
			return null;
		}
	}

	@Override
	public Optional<EmployeeType> findById(int id) {
		Optional<EmployeeType> res = Optional.empty();
		try {
			res = EmployeeTypeRepository.findById(id);
			if (res.isPresent()) {
				return res;
			}
		} catch (Exception ex) {
			LOG.error("Error findById() EmployeeTypeServiceImpl", ex);
		}
		return res;
	}

	@Override
	public void deleteById(int id) {
		try {
			EmployeeTypeRepository.deleteById(id);;
		} catch (Exception ex) {
			LOG.error("Error deleteByid in EmployeeTypeServiceImpl()",ex);
		}
		
	}

}
