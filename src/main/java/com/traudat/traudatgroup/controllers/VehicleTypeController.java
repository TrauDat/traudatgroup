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

import com.traudat.traudatgroup.models.VehicleType;
import com.traudat.traudatgroup.services.VehicleTypeService;

@Controller
public class VehicleTypeController {
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@GetMapping(value = "/vehicleTypes")
	public String getVehicleType(Model model) {
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		
		return "VehicleType";
	}
	
	@PostMapping(value = "/vehicleTypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping(value = "vehicleTypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleType(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping(value = "/vehicleTypes/delete")
	public String deleteVehicleType(int id) {
		vehicleTypeService.deleteById(id);
		
		return "redirect:/vehicleTypes";
	}
}
