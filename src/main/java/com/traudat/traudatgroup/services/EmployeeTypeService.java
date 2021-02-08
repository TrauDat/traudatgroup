package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.EmployeeType;

public interface EmployeeTypeService {
	List<EmployeeType> getEmployeeTypes();
	
	EmployeeType save(EmployeeType EmployeeType);
	
	Optional<EmployeeType> findById(int id);
	
	void deleteById(int id);
}
