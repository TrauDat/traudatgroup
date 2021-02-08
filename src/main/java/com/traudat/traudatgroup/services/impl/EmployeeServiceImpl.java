package com.traudat.traudatgroup.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.Employee;
import com.traudat.traudatgroup.repositories.EmployeeRepository;
import com.traudat.traudatgroup.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> listEmployees = Collections.emptyList();
		try {
			listEmployees = employeeRepository.findAll();
			return listEmployees;
		} catch (Exception ex) {
			LOG.error("Error getEmployees() in EmployeeServiceImpl", ex);
		}
		return listEmployees;
	}

	@Override
	public Employee save(Employee Employee) {
		try {
			return employeeRepository.save(Employee);
		} catch(Exception ex) {
			LOG.error("Error save() in EmployeeServiceImpl", ex);
			return null;
		}
	}

	@Override
	public Optional<Employee> findById(int id) {
		Optional<Employee> res = Optional.empty();
		try {
			res = employeeRepository.findById(id);
			if (res.isPresent()) {
				return res;
			}
		} catch (Exception ex) {
			LOG.error("Error findById() EmployeeServiceImpl", ex);
		}
		return res;
	}

	@Override
	public void delete(int id) {
		try {
			employeeRepository.deleteById(id);;
		} catch (Exception ex) {
			LOG.error("Error deleteByid in EmployeeServiceImpl()",ex);
		}
		
	}

	@Override
	public List<Employee> findByKeyword(String keyword) {
		try {
			employeeRepository.findByKeyword(keyword);
		} catch (Exception ex) {
			LOG.error("Error deleteByid in EmployeeServiceImpl()",ex);
			
		}
		return Collections.emptyList();
	}
	
}
