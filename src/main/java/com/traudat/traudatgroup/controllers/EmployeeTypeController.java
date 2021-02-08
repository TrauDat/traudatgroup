package com.traudat.traudatgroup.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traudat.traudatgroup.models.EmployeeType;
import com.traudat.traudatgroup.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping(value = "/employeeTypes")
	public String getEmployeeType(Model model) {
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		
		return "EmployeeType";
	}
	
	@PostMapping(value = "/employeeTypes/addNew")
	public String addNew(EmployeeType EmployeeType) {
		employeeTypeService.save(EmployeeType);
		
		return "redirect:/employeeTypes";
	}
	
	@RequestMapping(value = "employeeTypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeService.findById(id);
	}
	
	@RequestMapping(value = "/employeeTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateEmployeeType(EmployeeType EmployeeType) {
		employeeTypeService.save(EmployeeType);
		
		return "redirect:/employeeTypes";
	}
	
	@RequestMapping(value = "/employeeTypes/delete")
	public String deleteEmployeeType(int id) {
		employeeTypeService.deleteById(id);
		
		return "redirect:/employeeTypes";
	}
}
