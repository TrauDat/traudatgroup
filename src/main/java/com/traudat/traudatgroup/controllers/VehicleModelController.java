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

import com.traudat.traudatgroup.models.VehicleModel;
import com.traudat.traudatgroup.services.VehicleModelService;

@Controller
public class VehicleModelController {
	@Autowired
	private VehicleModelService vehicleModelService;
	
	@GetMapping(value = "/vehicleModels")
	public String getVehicleModel(Model model) {
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());
		
		return "VehicleModel";
	}
	
	@PostMapping(value = "/vehicleModels/addNew")
	public String addNew(VehicleModel VehicleModel) {
		vehicleModelService.save(VehicleModel);
		
		return "redirect:/vehicleModels";
	}
	
	@RequestMapping(value = "vehicleModels/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleModel(VehicleModel VehicleModel) {
		vehicleModelService.save(VehicleModel);
		
		return "redirect:/vehicleModels";
	}
	
	@RequestMapping(value = "/vehicleModels/delete")
	public String deleteVehicleModel(int id) {
		vehicleModelService.deleteById(id);
		
		return "redirect:/vehicleModels";
	}
}
