package com.traudat.traudatgroup.services;

import java.util.List;
import java.util.Optional;

import com.traudat.traudatgroup.models.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployees();
	
	Employee save(Employee employee);
	
	Optional<Employee> findById(int id);
	
	void delete(int id);
	
	public List<Employee> findByKeyword(String keyword);
	
}
