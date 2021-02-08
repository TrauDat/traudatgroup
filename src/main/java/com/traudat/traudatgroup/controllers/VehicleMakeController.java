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

import com.traudat.traudatgroup.models.VehicleMake;
import com.traudat.traudatgroup.services.CountryService;
import com.traudat.traudatgroup.services.StateService;
import com.traudat.traudatgroup.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	@Autowired
	private VehicleMakeService vehicleMakeService;
	
	@GetMapping(value = "/vehicleMakes")
	public String getVehicleMake(Model model) {
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		
		return "vehicleMake";
	}
	
	@PostMapping(value = "/vehicleMakes/addNew")
	public String addNew(VehicleMake VehicleMake) {
		vehicleMakeService.save(VehicleMake);
		
		return "redirect:/vehicleMakes";
	}
	
	@RequestMapping(value = "vehicleMakes/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		
		return "redirect:/vehicleMakes";
	}
	
	@RequestMapping(value = "/vehicleMakes/delete")
	public String deleteVehicleMake(int id) {
		vehicleMakeService.deleteById(id);
		
		return "redirect:/vehicleMakes";
	}
}
